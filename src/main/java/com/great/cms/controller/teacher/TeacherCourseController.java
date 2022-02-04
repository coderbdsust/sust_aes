package com.great.cms.controller.teacher;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Teacher;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.TeacherService;
import com.great.cms.service.TeachesService;
import com.great.cms.service.UserService;

@Controller
@RequestMapping("/teacher")
@Secured("ROLE_TEACHER")
public class TeacherCourseController {

	private static final Logger log = LoggerFactory.getLogger(TeacherCourseController.class);

	@Autowired
	TeacherService teacherService;
	@Autowired
	UserService userService;
	@Autowired
	TeachesService teachesService;
	@Autowired
	CourseRegistrationService courseRegService;

	@RequestMapping(value = "/course/reg/approve", method = RequestMethod.GET)
	public String regApprove(Course course, Model uiModel, RedirectAttributes redirectAttr) {
		log.debug("GET: /");
		log.debug("Course: " + course);
		uiModel.addAttribute("courseRegistration", new CourseRegistration());
		uiModel.addAttribute("courseRegistrationList", courseRegService.findByCourseId(course));
		if (course == null) {
			log.debug("GET: /teacher/course/reg/approve");
			return "redirect:/teacher/course/reg/open";
		}
		log.debug("GET: /teacher/course/reg/approve");
		return "teacher/course_reg_approve";
	}

	@RequestMapping(value = "/course/reg/approve", method = RequestMethod.POST)
	public String saveRegApprove(CourseRegistration courseReg, Model uiModel) {
		log.debug("POST: /");
		log.debug("CourseRegistration: " + courseReg);
		log.debug("POST: /teacher/course/reg/approve");
		return "redirect:/teacher/course/reg/approve";
	}

	@RequestMapping(value = "/course/reg/open", method = RequestMethod.GET)
	public String showAvailableCourse(Principal principal, Model uiModel) {
		log.debug("GET: /");
		Teacher teacher = teacherService.getTeacherByUserId(userService.getUser(principal.getName()));
		uiModel.addAttribute("course", new Course());
		uiModel.addAttribute("teachesList", teachesService.findByInstructorId(teacher));
		log.debug("GET: /course/reg/open");
		return "teacher/course_reg_open";
	}

	@RequestMapping(value = "/course/reg/open", method = RequestMethod.POST)
	public String showAvailableCourse(Course course, Model uiModel, RedirectAttributes redirectAttr) {
		log.debug("POST: /");
		log.debug("Course" + course);
		if (course != null) {
			redirectAttr.addFlashAttribute("course", course);
			log.debug("POST: /course/reg/open");
			return "redirect:/teacher/course/reg/approve";
		} else {
			log.debug("POST: /course/reg/open");
			return "teacher/course_reg_open";
		}
	}

}
