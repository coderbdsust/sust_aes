package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/question")
public class QuestionAddController {

	@RequestMapping(value = "/exam/add", method = RequestMethod.GET)
	public String showAvailableQuestion() {
		System.out.println("GET: /question/exam/add");
		
		return "question/add_exam_question";
	}
	
	
	@RequestMapping(value = "/exam/add", method = RequestMethod.POST)
	public String saveExamQuestion() {
		System.out.println("POST: /question/exam/add");
		
		return "redirect:/question/exam/add";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateQuestion() {
		System.out.println("GET: /question/create");
		
		return "question/create_question";
	}
}
