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

import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Student;
import com.great.cms.entity.User;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.CourseService;
import com.great.cms.service.StudentService;
import com.great.cms.service.UserService;

@Controller
@RequestMapping("/student")
@Secured("ROLE_STUDENT")
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;
	@Autowired
	CourseRegistrationService courseRegService;

	@Autowired
	UserService userService;

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile(Principal principal, Model uiModel) {
		Student student = getStudent(principal.getName());
		if (student == null) {
			return "redirect:/student/profile/edit";
		}
		uiModel.addAttribute("student", student);
		System.out.println("/student/profile");
		return "student/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editProfile(Principal principal, Model uiModel) {
		System.out.println("student/profile/edit");
		Student student = getStudent(principal.getName());
		uiModel.addAttribute("student", student);
		return "student/edit";
	}

	private Student getStudent(String studentName) {
		User user = userService.getUser(studentName);
		Student student = studentService.getStudentByUserId(user);
		return student;
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(Student student, BindingResult bandingResult) {
		System.out.println("student/profile/edit");
		System.out.println("Edit Student: " + student);
		return "redirect:/student/profile";
	}

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
//		courseRegService.saveOrUpdate(courseReg);
		return "redirect:/student/course/registration";
	}

}
