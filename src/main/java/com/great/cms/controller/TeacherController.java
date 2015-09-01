package com.great.cms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.User;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.DesignationService;
import com.great.cms.service.TeacherService;
import com.great.cms.service.TeachesService;
import com.great.cms.service.UserService;

@Controller
@RequestMapping("/teacher")
@Secured("ROLE_TEACHER")
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DesignationService designationService;
	@Autowired
	UserService userService;
	@Autowired
	TeachesService teachesService;
	@Autowired
	CourseRegistrationService courseRegService;

	private Teacher getTeacher(String username) {
		User user = userService.getUser(username);
		System.out.println(user);
		Teacher teacher = teacherService.getTeacherByUserId(user);
		System.out.println(teacher);
		if (teacher == null) {
			teacher = new Teacher();
		}
		teacher.setUserId(user);
		return teacher;
	}

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile(Principal principal, Model uiModel) {

		Teacher teacher = getTeacher(principal.getName());
		if (teacher.getInstructorId() == null) {
			return "redirect:/teacher/profile/edit";
		}
		System.out.println("/teacher/profile");
		uiModel.addAttribute("teacher", teacher);
		return "teacher/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editProfile(Principal principal, Model uiModel) {
		System.out.println("GET: teacher/profile/edit");

		uiModel.addAttribute("designationList",
				designationService.getDesignations());
		uiModel.addAttribute("departmentList",
				departmentService.getDepartments());

		Teacher teacher = getTeacher(principal.getName());
		System.out.println("Init: " + teacher);
		uiModel.addAttribute("teacher", teacher);

		return "teacher/edit";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(Teacher teacher, BindingResult bandingResult,
			RedirectAttributes redirectAttributes) {
		System.out.println("POST: teacher/profile/edit");
		System.out.println("Edit teacher: " + teacher);
		teacherService.saveOrUpdateTeacher(teacher);
		redirectAttributes.addFlashAttribute("message",
				"- Updated Successfully");
		return "redirect:/teacher/profile";
	}

	@RequestMapping(value = "/course/reg/approve", method = RequestMethod.GET)
	public String regApprove(Course course, Model uiModel,
			RedirectAttributes redirectAttr) {

		System.out.println("GET: teacher/course/reg/approve");
		System.out.println("Course: " + course);

		uiModel.addAttribute("courseRegistration", new CourseRegistration());
		uiModel.addAttribute("courseRegistrationList",
				courseRegService.findByCourseId(course));

		if (course == null) {
			return "redirect:/teacher/course/reg/open";
		}

		return "teacher/course_reg_approve";
	}

	@RequestMapping(value = "/course/reg/approve", method = RequestMethod.POST)
	public String saveRegApprove(CourseRegistration courseReg, Model uiModel) {
		System.out.println("POST: teacher/course/reg/approve");
		System.out.println("CourseRegistration: " + courseReg);
		return "redirect:/teacher/course/reg/approve";
	}

	@RequestMapping(value = "/course/reg/open", method = RequestMethod.GET)
	public String showAvailableCourse(Principal principal, Model uiModel) {
		Teacher teacher = teacherService.getTeacherByUserId(userService
				.getUser(principal.getName()));
		System.out.println("GET: /course/reg/open");

		uiModel.addAttribute("course", new Course());
		uiModel.addAttribute("teachesList",
				teachesService.findByInstructorId(teacher));

		return "teacher/course_reg_open";
	}

	@RequestMapping(value = "/course/reg/open", method = RequestMethod.POST)
	public String showAvailableCourse(Course course, Model uiModel,
			RedirectAttributes redirectAttr) {

		System.out.println("POST: /course/reg/open");
		System.out.println(course);

		if (course != null) {
			redirectAttr.addFlashAttribute("course", course);
			return "redirect:/teacher/course/reg/approve";
		} else {
			return "teacher/course_reg_open";
		}
	}
}
