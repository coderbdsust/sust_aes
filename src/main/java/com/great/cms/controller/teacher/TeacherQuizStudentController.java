package com.great.cms.controller.teacher;

import java.security.Principal;
import java.util.List;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.service.QuestionAnswerService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;
import com.great.cms.service.TeachesService;

@Controller
@RequestMapping("/teacher/quiz")
public class TeacherQuizStudentController {

	private static final Logger log = LoggerFactory.getLogger(TeacherQuizStudentController.class);

	@Autowired
	TeachesService teachesService;
	@Autowired
	QuizService quizService;
	@Autowired
	QuizRegistrationService quizRegService;
	@Autowired
	QuestionAnswerService questionAnswerService;

	@RequestMapping("/students/{quizId}")
	public String showStdQuizRegPage(Principal principal, @PathVariable Long quizId, Model uiModel) {
		log.debug("GET: /");
		Quiz quiz = quizService.getQuiz(quizId);
		List<QuizRegistration> quizRegList = quizRegService.getQuizRegistrationsByQuiz(quiz);
		uiModel.addAttribute("quizRegList", quizRegList);
		uiModel.addAttribute("quizRegistration", new QuizRegistration());
		uiModel.addAttribute("quiz", quiz);
		log.debug("GET: /teacher/quiz/student/" + quizId);
		return "teacher/quiz/teach_quiz_students_dt";
	}

	@RequestMapping(value = "/students/approve", method = { RequestMethod.GET })
	public String stdQuizRegApprove(Principal principal, QuizRegistration quizRegistration, Model uiModel,
			RedirectAttributes redirectAttr) {
		log.debug("GET: /");
		QuizRegistration savedQuizReg = quizRegService
				.getQuizRegistrationById(quizRegistration.getQuizRegistrationId());
		quizRegistration.setAttendTime(savedQuizReg.getAttendTime());
		quizRegistration.setSubmitTime(savedQuizReg.getSubmitTime());
		quizRegService.saveOrUpdate(quizRegistration);
		redirectAttr.addAttribute("quizId", quizRegistration.getQuizId().getQuizId());
		log.debug("GET: /teacher/quiz/students/approve " + quizRegistration);
		return "redirect:/teacher/quiz/students/{quizId}";
	}

	@RequestMapping(value = "/students/api/approve", method = { RequestMethod.POST })
	@ResponseBody
	public Integer stdQuizRegRestApprove(Principal principal, QuizRegistration quizRegistration, Model uiModel,
			RedirectAttributes redirectAttr) {
		log.debug("POST: /");
		QuizRegistration savedQuizReg = quizRegService
				.getQuizRegistrationById(quizRegistration.getQuizRegistrationId());
		quizRegistration.setAttendTime(savedQuizReg.getAttendTime());
		quizRegistration.setSubmitTime(savedQuizReg.getSubmitTime());
		quizRegService.saveOrUpdate(quizRegistration);
		log.debug("POST: /teacher/quiz/students/api/approve " + quizRegistration);
		return HttpStatus.SC_OK;
	}
}
