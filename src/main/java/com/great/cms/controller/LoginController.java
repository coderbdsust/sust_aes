package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class LoginController {
	
	@RequestMapping("/login")
	public String loginPage(){
		return "login";
	}

}
