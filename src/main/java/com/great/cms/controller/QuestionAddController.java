package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/question")
public class QuestionAddController {

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAvailableQuestion() {
		System.out.println("GET: /question/add");
		
		return "question/question_add";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveExamQuestion() {
		System.out.println("POST: /question/add");
		
		return "redirect:/question/add";
	}
}
