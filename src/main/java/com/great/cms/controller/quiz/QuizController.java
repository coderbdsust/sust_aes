package com.great.cms.controller.quiz;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.great.cms.controller.util.QuestionUtil;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.Teaches;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizQuestionService;
import com.great.cms.service.QuizService;
import com.great.cms.service.TeachesService;

@Controller
@RequestMapping("/quiz")
@Secured(value = { "ROLE_ADMIN", "ROLE_TEACHER", "ROLE_STUDENT" })
public class QuizController {

	@Autowired
	TeachesService teachesService;
	@Autowired
	QuizService quizService;
	@Autowired
	QuestionService questionService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd MMMM yyyy - hh:mm a"), true));
	}

	@RequestMapping("/create")
	@Secured({ "ROLE_TEACHER", "ROLE_ADMIN" })
	public String createNewQuiz(Principal principal, Model uiModel) {

		System.out.println("GET: quiz/create");
		Teacher teacher = UserUtil.getInstance().getTeacher(principal);
		List<Teaches> teachesList = teachesService.findByInstructorId(teacher);
		uiModel.addAttribute("quiz", new Quiz());
		uiModel.addAttribute("teachesList", teachesList);
		return "teacher/quiz/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveNewQuiz(Quiz quiz, RedirectAttributes redirectAttr) {
		System.out.println("POST: quiz/create");
		System.out.println(quiz);
		quizService.saveOrUpdate(quiz);
		Quiz savedQuiz = quizService.getQuizesByCreateDateAndTeachesId(
				quiz.getCreateDate(), quiz.getTeachesId());
		redirectAttr.addAttribute("id", savedQuiz.getQuizId());
		System.out.println("Quiz Saved Id: " + savedQuiz.getQuizId());
		System.out.println("Redirectig to quiz/question/add/"
				+ savedQuiz.getQuizId());
		return "redirect:/quiz/question/add/{id}";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editQuiz(@PathVariable Long id,
			RedirectAttributes redirectAttr) {
		System.out.println("GET: quiz/edit/{id}" + id);
		Quiz savedQuiz = quizService.getQuiz(id);
		System.out.println(savedQuiz);
		redirectAttr.addAttribute("id", savedQuiz.getQuizId());
		return "redirect:/quiz/question/add/{id}";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQuiz(@PathVariable Long id,
			RedirectAttributes redirectAttr) {
		System.out.println("GET: quiz/delete/{id}" + id);
		quizService.delete(id);
		return "redirect:/teacher/quiz/dashboard";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewQuiz(@PathVariable Long id, Model uiModel) {
		System.out.println("GET: quiz/view/{id}" + id);
		Quiz savedQuiz = quizService.getQuiz(id);
		System.out.println(savedQuiz);
		List<Question> assignedQuestions = questionService
				.findAssignedQuestions(savedQuiz);
		
		long totalMarks = QuestionUtil.getInstance().getTotalMarks(
				assignedQuestions);
		int totalQuestions = QuestionUtil.getInstance().countTotalQuestions(
				assignedQuestions);
		
		uiModel.addAttribute("quiz", savedQuiz);
		uiModel.addAttribute("totalQuestions", totalQuestions);
		uiModel.addAttribute("totalMarks", totalMarks);
		return "teacher/quiz/teach_quiz_view";
	}

}
