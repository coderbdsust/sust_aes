package com.great.cms.controller.question;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.entity.Question;
import com.great.cms.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionCreationController {

	@Autowired
	QuestionService questionService;

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
	public Question saveQuestion(Principal principal, Question question) {
		System.out.println("POST: /question/create");
		System.out.println(question);
//		questionService.saveOrUpdate(question);
//		Question savedQuestion = questionService.findByCreationTimeAndCourseId(
//				question.getCreatedTime(), question.getCourseId());
		
//		return savedQuestion;
		return question;
	}
}