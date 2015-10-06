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

import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.Teaches;
import com.great.cms.security.UserUtil;
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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd MMMM yyyy - hh:mm a"), true));
	}

	@RequestMapping("/create")
	@Secured({ "ROLE_TEACHER", "ROLE_ADMIN" })
	public String createNewQuiz(Principal principal, Model uiModel) {

		System.out.println("GET: quiz/create");

		Teacher teacher = UserUtil.getInstance()
				.getTeacher(principal.getName());
		List<Teaches> teachesList = teachesService.findByInstructorId(teacher);
		uiModel.addAttribute("quiz", new Quiz());
		uiModel.addAttribute("teachesList", teachesList);

		return "quiz/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveNewQuiz(Quiz quiz, Model model,
			RedirectAttributes redirectAttr) {
		System.out.println("POST: quiz/create");
		quizService.saveOrUpdate(quiz);
		Quiz savedQuiz = quizService.getQuizesByCreateDateAndTeachesId(
				quiz.getCreateDate(), quiz.getTeachesId());
		redirectAttr.addFlashAttribute("quiz", savedQuiz);
		return "redirect:/quiz/question/add";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editQuiz(@PathVariable Long id, RedirectAttributes redirectAttr) {
		System.out.println("GET: quiz/edit/{id}"+id);
		Quiz savedQuiz = quizService.getQuiz(id);
		System.out.println(savedQuiz);
		redirectAttr.addFlashAttribute("id", savedQuiz.getQuizId());
		return "redirect:/quiz/question/add";
	}
	
}
