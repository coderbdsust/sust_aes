package com.great.cms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.entity.User;
import com.great.cms.enums.Role;
import com.great.cms.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger log = LoggerFactory
			.getLogger(AdminController.class);
	
	@Autowired private UserService userService;
	
	@RequestMapping({"/","/index",""})
	public String showAdmin(Model model){
		System.out.println("/admin/index/");
		model.addAttribute("usersCount", userService.countVerifiedUsers());
		model.addAttribute("verificationsNeed", userService.countVerificationNeed());
		return "admin/index";
		
	}
	
}
