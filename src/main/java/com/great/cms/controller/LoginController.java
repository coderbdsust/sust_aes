package com.great.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.User;
import com.great.cms.service.UserService;

@Controller
@RequestMapping("/account")
public class LoginController {
	static final Logger log = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/{pageName}", method = RequestMethod.GET)
	public String userEntry(@PathVariable String pageName, Model uiModel) {
		uiModel.addAttribute(pageName, true);
		uiModel.addAttribute("user", new User());
		System.out.println("/account/user/");
		return "login";
	}
	
	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public String userSignUpEntry(User user, BindingResult result,
			Model uiModel, RedirectAttributes redirectAttr) {
		System.out.println("/user/signup");
		boolean status = userService.usernameExists(user.getUsername());
		if (status == true) {
			System.out.println("User account creation rejected!");
			redirectAttr.addFlashAttribute("userExists",
					"Username already taken, try another!");
			return "redirect:/account/user/signup";
		} else {
			userService.saveOrUpdate(user);
			System.out.println("User account created!");
			uiModel.addAttribute("message",
					"User successfully created, Admin verification needed!");
			return "message";
		}
	}

}
