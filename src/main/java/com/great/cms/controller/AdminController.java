package com.great.cms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.User;
import com.great.cms.enums.Role;
import com.great.cms.service.UserService;
import com.great.cms.utils.editor.RoleEditor;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger log = LoggerFactory
			.getLogger(AdminController.class);

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		log.debug("initBinder(WebDataBinder binder)");
		binder.registerCustomEditor(Role.class, new RoleEditor());		
	}
	
	@RequestMapping({ "/", "/index", "" })
	public String showAdmin(Model model) {
		System.out.println("/admin/index/");
		model.addAttribute("usersCount", userService.countVerifiedUsers());
		model.addAttribute("verificationsNeed",
				userService.countVerificationNeed());
		return "admin/index";

	}

	@RequestMapping(value = "/verification", method = RequestMethod.GET)
	public String userVerification(Model uiModel) {
		System.out.println("/admin/verification/");
		List<User> nonVerifiedUsers = userService.nonVerifiedUsers();
		uiModel.addAttribute("nonVerifiedUsers", nonVerifiedUsers);
		return "admin/verify";

	}

}
