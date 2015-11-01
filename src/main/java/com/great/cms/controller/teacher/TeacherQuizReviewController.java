package com.great.cms.controller.teacher;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.Teaches;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.QuizService;
import com.great.cms.service.TeachesService;

@Controller
@RequestMapping("/teacher/quiz")
public class TeacherQuizReviewController {

	@Autowired
	TeachesService teachesService;
	@Autowired
	QuizService quizService;

	
	@RequestMapping("/review/{id}")
	public String showStdQuizDashboard(Principal principal,Long id, Model uiModel) {
		System.out.println("/teacher/quiz/review");
	
		return "teacher/review/quiz_review";
	}
}
