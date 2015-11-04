package com.great.cms.controller.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;

@Controller
@RequestMapping("/student/quiz")
public class StudentQuizQuestionRestController {

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
		System.out.println("student/quiz/question/list/"+quizRegId);
		QuizRegistration quizReg = quizRegService
				.getQuizRegistrationById(quizRegId);
		List<Question> questionList = questionService
				.findAssignedQuestions(quizReg.getQuizId());
		return questionList;
	}

}
