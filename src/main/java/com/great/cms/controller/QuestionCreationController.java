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
@RequestMapping("/question")
public class QuestionCreationController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateQuestion() {
		System.out.println("GET: /question/create/");
		return "question/create_new_question";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String saveQuestion(Principal principal, Question question) {
		System.out.println("POST: /question/create");
		System.out.println(question);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(question);
		} catch (JsonProcessingException jpe) {
			return null;
		}
		
//		return question;
	}
}
