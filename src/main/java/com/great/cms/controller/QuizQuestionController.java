package com.great.cms.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.great.cms.entity.Question;

@Controller
@RequestMapping("/quiz")
public class QuizQuestionController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
	}

	@RequestMapping(value = "/question/add", method = RequestMethod.GET)
	public String showAvailableQuestion() {
		System.out.println("GET: /question/exam/add");

		return "question/p_add_exam_question";
	}

	@RequestMapping(value = "/question/add", method = RequestMethod.POST)
	public String saveExamQuestion() {
		System.out.println("POST: /question/exam/add");

		return "redirect:/question/exam/add";
	}

}
