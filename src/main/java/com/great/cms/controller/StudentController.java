package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping({"/profile","/",""})
	public String showProfile(){
		return "student/profile";
	}
}
