package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

/*	@Autowired
	private UserService userService;
*/
	@RequestMapping("/")
	public String showHome() {
		System.out.println("/home");
		return "home";
	}

}
