package com.great.cms.controller.student;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/student/quiz")
public class StudentQuizController {

	@RequestMapping("/answer")
	public String showExamQuestions(Model model) {
		System.out.println("student/quiz/answer");
		return "student/quiz/quiz_answer_sheet";
	}
	
	@RequestMapping("/dashboard")
	public String showStdExamDashboard(Principal principal, Model uiModel) {
		System.out.println("student/quiz/dashboard");
		
		return "student/quiz/std_quiz_dashboard";
	}
	
	@RequestMapping("/view")
	public String showStdExamView(Model model) {
		System.out.println("/quiz/question");
		return "student/quiz/std_quiz_view";
	}

}
