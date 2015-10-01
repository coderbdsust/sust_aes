package com.great.cms.controller;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.Quiz;


@Controller
@RequestMapping("/quiz")
@Secured(value = { "ROLE_ADMIN", "ROLE_TEACHER", "ROLE_STUDENT" })
public class QuizController {

	@RequestMapping("/create")
	@Secured({ "ROLE_TEACHER", "ROLE_ADMIN" })
	public String createNewTest(Model uiModel) {
		uiModel.addAttribute("quiz", new Quiz());
		return "quiz/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveNewTest() {
		return "redirect:/quiz/show";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editNewTest() {
		return "redirect:/quiz/show";
	}

	@RequestMapping("/show")
	public String showAvailableTest(Principal principal) {
		/* String username = principal.getName(); */
		return "quiz/showlist";
	}
}
