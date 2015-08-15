package com.great.cms.controller;

import java.net.Authenticator.RequestorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.Student;
import com.great.cms.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping({ "/profile", "/", "" })
	public String showProfile() {
		System.out.println("/student/profile");
		return "student/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editProfile() {
		System.out.println("student/profile/edit");
		return "student/edit";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(Student student, BindingResult bandingResult) {
		System.out.println("student/profile/edit");
		System.out.println("Edit Student: " + student);
		return "redirect:/student/profile";
	}

}
