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
public class UserController {

	@Autowired
	private UserService userService;
	

	@RequestMapping("/newuser")
	public String newUser(Model model) {


		return "newuser";
	}

	@RequestMapping("/showusers")
	public String showUsers(Model model) {
//		List<User> users = (List<User>) userService.getUsers();
//		model.addAttribute("users",users);
		return "user";
	}

	@RequestMapping("/createuser")
	public String saveUser(Model model, User user, Integer roleId, BindingResult results) {


		return "message";
	}

	@RequestMapping("/newrole")
	public String newRole() {
		return "newrole";
	}

	@RequestMapping("/createrole")
	public String createRole(Model model) {
		return "createrole";
		
		
	}
}
