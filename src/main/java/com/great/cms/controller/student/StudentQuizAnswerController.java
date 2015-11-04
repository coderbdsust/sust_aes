package com.great.cms.controller.student;

import java.security.Principal;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.entity.Student;
import com.great.cms.enums.QuestionType;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;

@Controller
@RequestMapping("/student/quiz")
public class StudentQuizAnswerController {

	@Autowired
	QuizService quizService;

	@Autowired
	QuestionService questionService;
	@Autowired
	CourseRegistrationService courseRegService;
	@Autowired
	QuizRegistrationService quizRegService;

	@RequestMapping("/answer/{quizId}")
	public String showExamQuestions(Principal principal,
			@PathVariable Long quizId, Model uiModel) {
		System.out.println("student/quiz/answer");
		Student student = UserUtil.getInstance().getStudent(principal);
		QuizRegistration quizReg = quizRegService
				.getQuizRegistrationByStudentAndQuiz(student, quizId);
		uiModel.addAttribute("quizRegistration", quizReg);
		return "student/quiz/quiz_answer_sheet";
	}

	@RequestMapping(value = "/answer/save", method = RequestMethod.POST)
	public String showExamQuestions(Principal principal, Model uiModel) {
		System.out.println("student/quiz/answer/save");
		return "student/quiz/quiz_answer_sheet";
	}
}
