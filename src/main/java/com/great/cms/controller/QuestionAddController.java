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
		
		return "question/p_add_exam_question";
	}
	
	
	@RequestMapping(value = "/exam/add", method = RequestMethod.POST)
	public String saveExamQuestion() {
		System.out.println("POST: /question/exam/add");
		
		return "redirect:/question/exam/add";
	}
	
	@RequestMapping(value = "/create/mcq", method = RequestMethod.GET)
	public String showCreateMCQQuestion() {
		System.out.println("GET: /question/create/mcq");
		
		return "question/create_mcq_question";
	}
	
	@RequestMapping(value = "/create/fig", method = RequestMethod.GET)
	public String showCreateFigQuestion() {
		System.out.println("GET: /question/create/fig");
		
		return "question/create_fig_question";
	}
	
	@RequestMapping(value = "/create/desc", method = RequestMethod.GET)
	public String showCreateDescQuestion() {
		System.out.println("GET: /question/create/desc");
		
		return "question/create_desc_question";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showGenericQuestionPage() {
		System.out.println("GET: /question/create");
		
		return "question/create_new_question";
	}
}
