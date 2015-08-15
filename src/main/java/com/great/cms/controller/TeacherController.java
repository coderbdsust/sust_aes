package com.great.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.Student;
import com.great.cms.entity.Teacher;
import com.great.cms.service.StudentService;
import com.great.cms.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile() {
		System.out.println("/teacher/profile");
		return "teacher/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editProfile() {
		System.out.println("student/profile/edit");
		return "teacher/edit";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(Teacher teacher, BindingResult bandingResult) {
		System.out.println("student/profile/edit");
		System.out.println("Edit Student: " + teacher);
		return "redirect:/teacher/profile";
	}
}
