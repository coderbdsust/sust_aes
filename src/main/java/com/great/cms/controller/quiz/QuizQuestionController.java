package com.great.cms.controller.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.controller.bean.Questions;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizQuestion;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizQuestionService;
import com.great.cms.service.QuizService;
import com.great.cms.utils.simulator.TimeEstimater;

@Controller
@RequestMapping("/quiz")
public class QuizQuestionController {

	@Autowired
	QuizService quizService;
	@Autowired
	QuestionService questionService;
	@Autowired
	QuizQuestionService quizQuestionService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
	}

	@RequestMapping(value = "/question/add/{id}", method = RequestMethod.GET)
	public String showQuizQuestionPage(@PathVariable Long id, Model model) {
		System.out.println("GET: /question/quiz/add/" + id);
		Quiz quiz = quizService.getQuiz(id);
		List<Question> availableQuestions = questionService
				.findAvailableQuestions(quiz);
		List<Question> assignedQuestions = questionService
				.findAssignedQuestions(quiz);

		model.addAttribute("quiz", quiz);
		model.addAttribute("availableQuestionList", availableQuestions);
		model.addAttribute("assignedQuestionList", assignedQuestions);
		model.addAttribute("estimatedTime", TimeEstimater.getInstance()
				.getTotalTime(assignedQuestions));

		return "question/p_add_quiz_question";
	}

	@RequestMapping(value = "/question/available/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Question> availableQuizQuestion(Quiz quiz, Model model) {
		System.out.println("POST: quiz/question/available/" + quiz.getQuizId());
		List<Question> questions = null;
		return questions;
	}

	@RequestMapping(value = "/question/assigned/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Question> quizAssignedQuestion(Quiz quiz, Model model) {
		System.out.println("POST: quiz/question/assigned/" + +quiz.getQuizId());
		List<Question> questions = null;
		return questions;
	}

	@RequestMapping(value = "/question/assignto", method = RequestMethod.GET)
	public String saveQuizQuestion(Questions questions, Long totalTime,
			Long quizId, Model model) {
		System.out.println("GET: /quiz/question/assignto");
		System.out.println("QuizId:" + quizId);
		System.out.println("Total Time: " + totalTime);
		// System.out.println(questions);
		List<QuizQuestion> quizQuestionList = questions.getQuizQuestions();
		// System.out.println(quizQuestionList);
		for (QuizQuestion quizQuestion : quizQuestionList) {
			System.out.println("QuestionId: "
					+ quizQuestion.getQuestionId().getQuestionId());
			quizQuestionService.saveOrUpdateQuizQuestion(quizQuestion);
			
		}
		return "redirect:/teacher/quiz/dashboard";
	}

}
