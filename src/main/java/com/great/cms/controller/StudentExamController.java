package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/student/exam")
public class StudentExamController {

	@RequestMapping("/question")
	public String showExamQuestions(Model model) {
		System.out.println("/exam/question");
		return "exam/exam_question";
	}
	
	@RequestMapping("/dashboard")
	public String showStdExamDashboard(Model model) {
		System.out.println("/exam/question");
		return "exam/std_exam_dashboard";
	}
	
	@RequestMapping("/view")
	public String showStdExamView(Model model) {
		System.out.println("/exam/question");
		return "exam/std_exam_view";
	}

}
