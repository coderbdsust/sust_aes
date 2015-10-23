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
@RequestMapping("/teacher/quiz")
public class TeacherQuizController {

	@Autowired
	TeachesService teachesService;
	@Autowired
	QuizService quizService;

	@RequestMapping("/question/create")
	public String showQuizQuestions(Model model) {
		System.out.println("teacher/quiz/question/create");
		return "teacher/quiz/quiz_question";
	}

	@RequestMapping("/dashboard")
	public String showStdQuizDashboard(Principal principal, Model uiModel) {
		System.out.println("/teacher/quiz/dashboard");
		Teacher teacher = UserUtil.getInstance()
				.getTeacher(principal);
		List<Quiz> quizList = new ArrayList<Quiz>();
		List<Teaches> teachesList = teachesService.findByInstructorId(teacher);
//		System.out.println("TeachesList Found!");
		for (Teaches teaches : teachesList) {
			List<Quiz> quizes = quizService.getQuizes(teaches);
//			System.out.println("Quiz List Found!");
//			System.out.println("Teaches " + teaches.getTeachesId()+": Quiz-Count: " + quizes.size());
			if (!quizes.isEmpty())
				quizList.addAll(quizes);
		}
		uiModel.addAttribute("quizList", quizList);
		return "teacher/quiz/teach_quiz_dashboard";
	}
}
