package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile() {
		return "teacher/profile";
	}
}
