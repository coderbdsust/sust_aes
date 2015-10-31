package com.great.cms.controller.student;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student/quiz")
public class StudentQuizAnswerController {

	
	@RequestMapping("/answer")
	public String showExamQuestions(Principal principal, Model uiModel) {
		System.out.println("student/quiz/answer");

		return "student/quiz/quiz_answer_sheet";
	}
}
