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

import com.great.cms.entity.Course;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizService;

@Controller
@RequestMapping("/quiz")
public class QuizQuestionController {

	@Autowired
	QuizService quizService;
	@Autowired
	QuestionService questionService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
	}

	@RequestMapping(value = "/question/add/{id}", method = RequestMethod.GET)
	public String showQuizQuestionPage(@PathVariable Long id, Model model) {
		System.out.println("GET: /question/quiz/add/" + id);
		Quiz quiz = quizService.getQuiz(id);
		System.out.println(quiz);

		List<Question> availableQuestions = questionService
				.findAvailableQuestions(quiz);
		List<Question> assignedQuestions = questionService
				.findAssignedQuestions(quiz);
		model.addAttribute("quiz", quiz);
		model.addAttribute("availableQuestions", availableQuestions);
		model.addAttribute("assignedQuestions", assignedQuestions);
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

}
