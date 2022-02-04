package com.great.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping({"/","/home","/index"})
	public String showHome() {
		log.debug("GET: /");
		log.debug("GET: /home");
		return "home";
	}

} 
