package com.great.cms.controller;

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

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/course/registration", method = RequestMethod.GET)
	public String newCourseRegistration(Model uiModel) {
		System.out.println("student/course/registration");
		uiModel.addAttribute("courseList", courseService.getCourses());
		return "student/course_registration";
	}

	@RequestMapping(value = "/course/registration", method = RequestMethod.POST)
	public String courseRegistration(CourseRegistration courseReg,
			BindingResult bandingResult, RedirectAttributes redirectAttr) {

		System.out.println("student/course/registration");
		System.out.println("Course Reg:" + courseReg);
		redirectAttr.addFlashAttribute("message",
				" -Course Teacher Approval Pending!");
		// courseRegService.saveOrUpdate(courseReg);
		return "redirect:/student/course/registration";
	}

}
