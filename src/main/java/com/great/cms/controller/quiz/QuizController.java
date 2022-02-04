package com.great.cms.controller.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.controller.utils.QuestionUtil;
import com.great.cms.controller.utils.QuizTypeUtil;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.Teaches;
import com.great.cms.enums.QuizStatusType;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizService;
import com.great.cms.service.TeachesService;

@Controller
@RequestMapping("/quiz")
@Secured(value = { "ROLE_ADMIN", "ROLE_TEACHER", "ROLE_STUDENT" })
public class QuizController {

	private static final Logger log = LoggerFactory.getLogger(QuizController.class);

	@Autowired
	TeachesService teachesService;
	@Autowired
	QuizService quizService;
	@Autowired
	QuestionService questionService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		log.debug("/");
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("dd MMMM yyyy - hh:mm a"), true));
		log.debug("/initBinder");
	}

	@RequestMapping("/create")
	@Secured({ "ROLE_TEACHER", "ROLE_ADMIN" })
	public String createNewQuiz(Model uiModel) {
		log.debug("GET: /");
		Teacher teacher = UserUtil.getInstance().getTeacher();
		List<Teaches> teachesList = teachesService.findByInstructorId(teacher);
		uiModel.addAttribute("quiz", new Quiz());
		uiModel.addAttribute("teachesList", teachesList);
		log.debug("GET: /quiz/create");
		return "teacher/quiz/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveNewQuiz(Quiz quiz, RedirectAttributes redirectAttr) {
		log.debug("POST: /");
		log.debug("Quiz : " + quiz);
		quizService.saveOrUpdate(quiz);
		Quiz savedQuiz = quizService.getQuizesByCreateDateAndTeachesId(quiz.getCreateDate(), quiz.getTeachesId());
		redirectAttr.addAttribute("id", savedQuiz.getQuizId());
		log.debug("Quiz Saved ID: " + savedQuiz.getQuizId());
		log.debug("Redirectig to quiz/question/add/" + savedQuiz.getQuizId());
		log.debug("POST: /quiz/create");
		return "redirect:/quiz/question/add/{id}";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editQuiz(@PathVariable Long id, RedirectAttributes redirectAttr) {
		log.debug("GET: /");
		Quiz savedQuiz = quizService.getQuiz(id);
		log.debug("Quiz: "+savedQuiz);
		redirectAttr.addAttribute("id", savedQuiz.getQuizId());
		log.debug("GET: /quiz/edit/{id}" + id);
		return "redirect:/quiz/question/add/{id}";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQuiz(@PathVariable Long id, RedirectAttributes redirectAttr) {
		log.debug("GET: /");
		Quiz quiz = quizService.getQuiz(id);
		QuizStatusType quizStatusType = QuizTypeUtil.getInstance().getQuizStatusType(quiz, new Date());
		if (quizStatusType == QuizStatusType.Running) {
			redirectAttr.addAttribute("id", id);
			log.debug("GET: /quiz/delete/{id}" + id);
			return "redirect:/quiz/view/{id}";
		}
		quizService.delete(id);
		log.debug("GET: /quiz/delete/{id}" + id);
		return "redirect:/teacher/quiz/dashboard";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewQuiz(@PathVariable Long id, Model uiModel) {
		log.debug("GET: /");
		Quiz savedQuiz = quizService.getQuiz(id);
		log.debug("Saved Quiz: "+savedQuiz);
		List<Question> assignedQuestions = questionService.findAssignedQuestions(savedQuiz);

		double totalMarks = QuestionUtil.getInstance().getTotalMarks(assignedQuestions);
		int totalQuestions = QuestionUtil.getInstance().countTotalQuestions(assignedQuestions);

		uiModel.addAttribute("quiz", savedQuiz);
		uiModel.addAttribute("totalQuestions", totalQuestions);
		uiModel.addAttribute("totalMarks", totalMarks);
		uiModel.addAttribute("quizStatusType", QuizTypeUtil.getInstance().getQuizStatusType(savedQuiz, new Date()));
		log.debug("GET: /quiz/view/{id}" + id);
		return "teacher/quiz/teach_quiz_view";
	}

}
