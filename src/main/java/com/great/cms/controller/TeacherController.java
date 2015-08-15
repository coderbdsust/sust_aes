package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile() {
		System.out.println("/teacher/profile");
		return "teacher/profile";
	}
	
	@RequestMapping("profile/edit")
	public String editProfile() {
		System.out.println("/teacher/profile/edit");
		return "teacher/edit";
	}
}
