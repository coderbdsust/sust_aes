package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.entity.Course;

@Controller
@RequestMapping("/student/exam")
public class ExamController {
	
	
	
	@RequestMapping("/question")
	public String showExamQuestions(Model model) {
		System.out.println("/exam/question");
		return "exam/exam_question";
	}

}
