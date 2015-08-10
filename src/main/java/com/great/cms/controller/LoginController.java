package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class LoginController {

	@RequestMapping("/login")
	public String loginPage(Model uiModel) {
		uiModel.addAttribute("login", true);
		return "login";
	}

	@RequestMapping("/signup")
	public String signUpPage(Model uiModel) {
		uiModel.addAttribute("signup", true);
		return "login";
	}

}
