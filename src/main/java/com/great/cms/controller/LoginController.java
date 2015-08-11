package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class LoginController {

	@RequestMapping(value="/user/{pageName}",method= RequestMethod.GET)
	public String userEntry(@PathVariable String pageName,Model uiModel) {
		uiModel.addAttribute(pageName, true);
		return "login";
	}

}
