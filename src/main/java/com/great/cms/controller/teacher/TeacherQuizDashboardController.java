package com.great.cms.controller.teacher;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.Teaches;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.QuestionAnswerService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;
import com.great.cms.service.TeachesService;

@Controller
@RequestMapping("/teacher/quiz")
public class TeacherQuizDashboardController {
	
	private static final Logger log = LoggerFactory.getLogger(TeacherQuizDashboardController.class);

	@Autowired
	TeachesService teachesService;
	@Autowired
	QuizService quizService;
	@Autowired
	QuizRegistrationService quizRegService;
	@Autowired
	QuestionAnswerService questionAnswerService;
	
	@RequestMapping("/dashboard")
	public String showStdQuizDashboard(Model uiModel) {
		log.debug("GET: /");
		Teacher teacher = UserUtil.getInstance().getTeacher();
		List<Quiz> quizList = new ArrayList<Quiz>();
		List<Teaches> teachesList = teachesService.findByInstructorId(teacher);
		for (Teaches teaches : teachesList) {
			List<Quiz> quizes = quizService.getQuizes(teaches);
			if (!quizes.isEmpty())
				quizList.addAll(quizes);
		}
		uiModel.addAttribute("quizList", quizList);
		uiModel.addAttribute("teachesList", teachesList);
		log.debug("GET: /teacher/quiz/dashboard");
		return "teacher/quiz/teach_quiz_dashboard";
	}

}
