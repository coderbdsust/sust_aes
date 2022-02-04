package com.great.cms.controller.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.CourseRegistration;
import com.great.cms.service.CourseService;

@Controller
@RequestMapping("/student")
@Secured("ROLE_STUDENT")
public class StudentCourseController {

	private static final Logger log = LoggerFactory.getLogger(StudentCourseController.class);

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/course/registration", method = RequestMethod.GET)
	public String newCourseRegistration(Model uiModel) {
		log.debug("GET: /student/course/registration");
		uiModel.addAttribute("courseList", courseService.getCourses());
		log.debug("GET: /student/course/registration");
		return "student/course_registration";
	}

	@RequestMapping(value = "/course/registration", method = RequestMethod.POST)
	public String courseRegistration(CourseRegistration courseReg, BindingResult bandingResult,
			RedirectAttributes redirectAttr) {
		log.debug("POST: /");
		log.debug("Course Reg:" + courseReg);
		redirectAttr.addFlashAttribute("message", " - Course Teacher Approval Pending!");
		log.debug("POST: /student/course/registration");
		return "redirect:/student/course/registration";
	}

}
