package com.great.cms.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.User;
import com.great.cms.enums.Role;
import com.great.cms.service.UserService;

@Controller
@RequestMapping("/account")
public class LoginController {
	static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(User.class, new PropertyEditorSupport() {
			public void setAsText(final String text) {
				Role role = Role.valueOf(text);
				setValue(role);
			}
		});
	}

	@RequestMapping(value = "/user/{pageName}", method = RequestMethod.GET)
	public String userEntry(@PathVariable String pageName, Model uiModel) {
		uiModel.addAttribute(pageName, true);
		uiModel.addAttribute("user", new User());
		System.out.println("/account/user/");
		return "login";
	}

	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public String userSignUpEntry(User user, Role role, BindingResult result,
			Model uiModel, RedirectAttributes redirectAttr) {
		System.out.println("/user/signup");
		
		try {
			user.getRole().add(role);
			System.out.println(user);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
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
