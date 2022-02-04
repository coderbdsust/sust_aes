  package com.great.cms.controller.question;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.entity.Question;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionCreationRestController {
	
	private static final Logger log = LoggerFactory
			.getLogger(QuestionCreationRestController.class);

	@Autowired
	QuestionService questionService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		log.debug("/");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
		log.debug("/initBinder");
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateQuestion() {
		log.debug("GET: /");
		log.debug("GET: /question/create/");
		return "question/create_new_question";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Question saveQuestion(Question question) {
		log.debug("POST: /");
		question.setCreatedBy(UserUtil.getInstance().getTeacher());
		log.debug("Question: "+question);
		questionService.saveOrUpdate(question);
		Question savedQuestion = questionService.findByCreationTimeAndCourseId(
				question.getCreatedTime(), question.getCourseId());
		log.debug("Question Retrieved: " + savedQuestion.getCreatedBy());
		log.debug("POST: /question/create");
		return savedQuestion;
	}
}
