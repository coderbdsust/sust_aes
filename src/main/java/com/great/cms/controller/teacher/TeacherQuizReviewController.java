package com.great.cms.controller.teacher;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.controller.utils.QuestionUtil;
import com.great.cms.controller.utils.QuizTypeUtil;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.enums.QuizStatusType;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;
import com.great.cms.service.TeachesService;

@Controller
@RequestMapping("/teacher/quiz")
public class TeacherQuizReviewController {

	private static final Logger log = LoggerFactory.getLogger(TeacherQuizReviewController.class);

	@Autowired
	TeachesService teachesService;
	@Autowired
	QuizService quizService;
	@Autowired
	QuestionService questionService;
	@Autowired
	QuizRegistrationService quizRegService;

	@RequestMapping("/review/{id}")
	public String showStdReviewQuestions(@PathVariable Long id, Model uiModel, RedirectAttributes redirectAttr) {
		log.debug("GET: /");
		Quiz quiz = quizService.getQuiz(id);
		if (QuizTypeUtil.getInstance().getQuizStatusType(quiz, new Date()) != QuizStatusType.Finished) {
			redirectAttr.addAttribute("id", quiz.getQuizId());
			log.debug("GET: /teacher/quiz/review");
			return "redirect:/quiz/view/{id}";
		}
		List<Question> questionList = questionService.findAssignedQuestions(quiz);
		for (Question q : questionList) {
			log.debug(q.getQuestionId() + " ");
		}
		uiModel.addAttribute("questionList", questionList);
		uiModel.addAttribute("quiz", quiz);
		log.debug("GET: /teacher/quiz/review");
		return "teacher/review/quiz_review";
	}

	@RequestMapping("/marksheet/{id}")
	public String showStdQuizMarksheet(@PathVariable Long id, Model uiModel, RedirectAttributes redirectAttr) {
		log.debug("GET: /");
		Quiz quiz = quizService.getQuiz(id);
		List<Question> questions = questionService.findAssignedQuestions(quiz);
		double totalMarks = QuestionUtil.getInstance().getTotalMarks(questions);
		List<QuizRegistration> quizRegistrationList = quizRegService.getQuizRegistrationsByQuiz(quiz);
		uiModel.addAttribute("quizRegistrationList", quizRegistrationList);
		uiModel.addAttribute("totalMarks", totalMarks);
		uiModel.addAttribute("quiz", quiz);
		log.debug("GET: /teacher/quiz/marksheet " + id);
		return "teacher/review/quiz_marksheet";
	}
}
