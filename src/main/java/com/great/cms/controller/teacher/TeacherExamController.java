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
import com.great.cms.security.UserUtil;
import com.great.cms.service.QuizService;
import com.great.cms.service.TeachesService;

@Controller
@RequestMapping("/teacher/exam")
public class TeacherExamController {

	@Autowired
	TeachesService teachesService;
	@Autowired
	QuizService quizService;

	@RequestMapping("/question/create")
	public String showExamQuestions(Model model) {
		System.out.println("/exam/question");
		return "teacher/exam/exam_question";
	}

	@RequestMapping("/dashboard")
	public String showStdExamDashboard(Principal principal, Model uiModel) {
		System.out.println("/exam/question");
		Teacher teacher = UserUtil.getInstance()
				.getTeacher(principal.getName());
		List<Quiz> quizList = new ArrayList<Quiz>();
		List<Teaches> teachesList = teachesService.findByInstructorId(teacher);
		for (Teaches teaches : teachesList) {
			List<Quiz> quizes = quizService.getQuizes(teaches);
			System.out.println("Quiz: " + quizes.size());
			if (!quizes.isEmpty())
				quizList.addAll(quizes);
		}
		System.out.println("Total Quiz: " + quizList.size());
		uiModel.addAttribute("quizList", quizList);
		return "teacher/exam/teach_exam_dashboard";
	}
}
