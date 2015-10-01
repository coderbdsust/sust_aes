package com.great.cms.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.Teaches;
import com.great.cms.security.UserUtil;
import com.great.cms.service.TeachesService;

@Controller
@RequestMapping("/quiz")
@Secured(value = { "ROLE_ADMIN", "ROLE_TEACHER", "ROLE_STUDENT" })
public class QuizController {

	@Autowired
	TeachesService teachesService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd MMMM yyyy - hh:mm"), true));
	}

	@RequestMapping("/create")
	@Secured({ "ROLE_TEACHER", "ROLE_ADMIN" })
	public String createNewQuiz(Principal principal, Model uiModel) {

		System.out.println("quiz/create");

		Teacher teacher = UserUtil.getInstance()
				.getTeacher(principal.getName());
		// System.out.println(teacher);
		List<Teaches> teachesList = teachesService.findByInstructorId(teacher);

		// System.out.println("TeachesList: " + teachesList.size());

		uiModel.addAttribute("quiz", new Quiz());
		uiModel.addAttribute("teachesList", teachesList);

		return "quiz/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveNewQuiz(Quiz quiz) {
		System.out.println("POST: quiz/create");

		System.out.println(quiz);

		return "redirect:/quiz/create";
		// return "redirect:/quiz/show";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editNewQuiz() {
		return "redirect:/quiz/show";
	}

	@RequestMapping("/show")
	public String showAvailableQuiz(Principal principal) {
		/* String username = principal.getName(); */
		return "quiz/showlist";
	}
}
