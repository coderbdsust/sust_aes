package com.great.cms.controller.student;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.controller.utils.QuestionUtil;
import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.entity.Student;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;

@Controller
@RequestMapping("/student/quiz")
public class StudentQuizViewController {

	@Autowired
	CourseRegistrationService courseRegService;

	@Autowired
	QuizService quizService;

	@Autowired
	QuestionService questionService;

	@Autowired
	QuizRegistrationService quizRegistrationService;

	@RequestMapping(value = "/view/{quizId}", method = RequestMethod.GET)
	public String showStdExamView(Principal principal,
			@PathVariable Long quizId, Model uiModel) {
		System.out.println("/quiz/question " + quizId);
		Quiz quiz = quizService.getQuiz(quizId);
		List<Question> assignedQuestions = questionService
				.findAssignedQuestions(quiz);
		long totalMarks = QuestionUtil.getInstance().getTotalMarks(
				assignedQuestions);
		int totalQuestions = QuestionUtil.getInstance().countTotalQuestions(
				assignedQuestions);
		uiModel.addAttribute("quiz", quiz);
		uiModel.addAttribute("totalMarks", totalMarks);
		uiModel.addAttribute("totalQuestions", totalQuestions);
		return "student/quiz/std_quiz_view";
	}

	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String showStdExamApply(Principal principal, Long quizId,
			Integer courseId, Model uiModel, RedirectAttributes redirectAttr) {
		System.out.println("/student/quiz/apply/" + quizId + " " + courseId);

		redirectAttr.addAttribute("quizId", quizId);
		return "redirect:/student/quiz/view/{quizId}";
	}

	@RequestMapping(value = "/review/{quizId}", method = RequestMethod.GET)
	public String showStdExamReview(Principal principal,
			@PathVariable Long quizId, Model uiModel) {
		System.out.println("/quiz/question " + quizId);
		Quiz quiz = quizService.getQuiz(quizId);
		List<Question> assignedQuestions = questionService
				.findAssignedQuestions(quiz);
		long totalMarks = QuestionUtil.getInstance().getTotalMarks(
				assignedQuestions);
		int totalQuestions = QuestionUtil.getInstance().countTotalQuestions(
				assignedQuestions);
		uiModel.addAttribute("quiz", quiz);
		uiModel.addAttribute("totalMarks", totalMarks);
		uiModel.addAttribute("totalQuestions", totalQuestions);
		return "student/quiz/std_quiz_review";
	}

}
