package com.great.cms.controller.student;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.entity.Question;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;

@Controller
@RequestMapping("/student/quiz")
public class StudentQuizQuestionRestController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentQuizQuestionRestController.class);

	@Autowired
	CourseRegistrationService courseRegService;

	@Autowired
	QuizService quizService;

	@Autowired
	QuestionService questionService;

	@Autowired
	QuizRegistrationService quizRegService;

	@RequestMapping(value = "/question/list", method = RequestMethod.POST)
	@ResponseBody
	public List<Question> showQuizQuestion(Long quizRegId) {
		log.debug("POST: /");
		QuizRegistration quizReg = quizRegService
				.getQuizRegistrationById(quizRegId);
		List<Question> questionList = questionService
				.findAssignedQuestions(quizReg.getQuizId());
		log.debug("POST: /student/quiz/question/list/"+quizRegId);
		return questionList;
	}

}
