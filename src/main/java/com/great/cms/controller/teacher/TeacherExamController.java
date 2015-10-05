package com.great.cms.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/teacher/exam")
public class TeacherExamController {

	@RequestMapping("/question/create")
	public String showExamQuestions(Model model) {
		System.out.println("/exam/question");
		return "teacher/exam/exam_question";
	}
	
	@RequestMapping("/dashboard")
	public String showStdExamDashboard(Model model) {
		System.out.println("/exam/question");
		return "teacher/exam/teach_exam_dashboard";
	}

}
