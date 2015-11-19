package com.great.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.service.UserService;

@Controller
public class HomeController {
	private static final Logger log = LoggerFactory
			.getLogger(HomeController.class);


	@Autowired
	private UserService userService;

	@RequestMapping({"/","/home","/index"})
	public String showHome() {
		log.info("/home");
		log.debug("/home");
		return "home";
	}

} 
