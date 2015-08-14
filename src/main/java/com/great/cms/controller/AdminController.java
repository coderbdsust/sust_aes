package com.great.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.entity.User;
import com.great.cms.enums.Role;
import com.great.cms.service.UserService;


@Controller
@RequestMapping("/account")
public class AdminController {

	@RequestMapping("/admin")
	public String showAdmin(){
		return "layout/main";
		
	}
	
}
