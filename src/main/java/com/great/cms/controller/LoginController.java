package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class LoginController {

	@RequestMapping("/user/{pageName}")
	public String userEntry(@PathVariable String pageName,Model uiModel) {
		uiModel.addAttribute(pageName, true);
		return "login";
	}

}
