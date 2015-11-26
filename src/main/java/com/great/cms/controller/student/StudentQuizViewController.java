package com.great.cms.controller.student;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.controller.utils.QuestionUtil;
import com.great.cms.controller.utils.QuizTypeUtil;
import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Question;
import com.great.cms.entity.QuestionAnswer;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.entity.Student;
import com.great.cms.enums.QuizRegistrationType;
import com.great.cms.enums.QuizParticipationType;
import com.great.cms.enums.QuizStatusType;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.QuestionAnswerService;
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

	@Autowired
	QuestionAnswerService questionAnsService;

	@RequestMapping(value = "/view/{quizId}", method = RequestMethod.GET)
	public String showStdExamView(@PathVariable Long quizId, Model uiModel) {
		System.out.println("/quiz/question " + quizId);
		Student student = UserUtil.getInstance().getStudent();
		Quiz quiz = quizService.getQuiz(quizId);
		Course course = quiz.getTeachesId().getCourseId();
		List<Question> assignedQuestions = questionService
				.findAssignedQuestions(quiz);
		double totalMarks = QuestionUtil.getInstance().getTotalMarks(
				assignedQuestions);
		int totalQuestions = QuestionUtil.getInstance().countTotalQuestions(
				assignedQuestions);
		CourseRegistration courseReg = courseRegService
				.findByStudentAndCourseAndIsApproved(student, course);
		QuizRegistration quizReg = quizRegistrationService
				.getQuizRegistrationByCourseReg(quiz, courseReg);

		QuizRegistrationType regType = QuizTypeUtil.getInstance()
				.getQuizRegistrationType(quizReg);
		QuizParticipationType pType = QuizTypeUtil.getInstance()
				.getQuizParticipationType(quizReg, new Date(),regType);
		QuizStatusType quizStatusType = QuizTypeUtil.getInstance()
				.getQuizStatusType(quiz, new Date());

		uiModel.addAttribute("quiz", quiz);
		uiModel.addAttribute("totalMarks", totalMarks);
		uiModel.addAttribute("totalQuestions", totalQuestions);
		uiModel.addAttribute("registrationType", regType);
		uiModel.addAttribute("participationType", pType);
		uiModel.addAttribute("quizStatusType", quizStatusType);

		return "student/quiz/std_quiz_view";
	}

	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String showStdExamApply(Long quizId, Integer courseId,
			Model uiModel, RedirectAttributes redirectAttr) {
		System.out.println("/student/quiz/apply/" + quizId + " " + courseId);
		Student student = UserUtil.getInstance().getStudent();
		Course course = new Course(courseId);
		Quiz quiz = new Quiz(quizId);

		CourseRegistration courseReg = courseRegService
				.findByStudentAndCourseAndIsApproved(student, course);
		QuizRegistration quizReg = quizRegistrationService
				.getQuizRegistrationByCourseReg(quiz, courseReg);

		if (quizReg == null) {
			quizReg = new QuizRegistration();
			quizReg.setCourseRegId(courseReg);
			quizReg.setQuizId(quiz);
			quizRegistrationService.saveOrUpdate(quizReg);
		}

		redirectAttr.addAttribute("quizId", quizId);
		return "redirect:/student/quiz/view/{quizId}";
	}

	@RequestMapping(value = "/review/{quizId}", method = RequestMethod.GET)
	public String showStdExamReview(@PathVariable Long quizId, Model uiModel, RedirectAttributes redirectAttr) {
		System.out.println("/quiz/question " + quizId);
		Quiz quiz = quizService.getQuiz(quizId);
		Student student = UserUtil.getInstance().getStudent();
		QuizRegistration quizReg = quizRegistrationService
				.getQuizRegistrationByStudentAndQuiz(student, quizId);
		if(quizReg.getIsExamReviewed()==false){
			redirectAttr.addAttribute("quizId", quiz.getQuizId());
			return "redirect:/student/quiz/view/{quizId}";
		}
		List<QuestionAnswer> questionAnswers = questionAnsService
				.getQuestionAnswersByQuizRegistration(quizReg);
		List<Question> assignedQuestions = questionService
				.findAssignedQuestions(quiz);
		double totalMarks = QuestionUtil.getInstance().getTotalMarks(
				assignedQuestions);
		int totalQuestions = QuestionUtil.getInstance().countTotalQuestions(
				assignedQuestions);
		int obtainMarks = QuestionUtil.getInstance().getObtainMarks(questionAnswers);
		uiModel.addAttribute("quiz", quiz);
		uiModel.addAttribute("totalMarks", totalMarks);
		uiModel.addAttribute("obtainMarks", obtainMarks);
		uiModel.addAttribute("totalQuestions", totalQuestions);
		return "student/quiz/std_quiz_review";
	}

}
