package com.great.cms.controller.student;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpStatus;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.controller.bean.StudentQuestionAnswers;
import com.great.cms.controller.utils.QuestionAnswerSimulatorUtil;
import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Question;
import com.great.cms.entity.QuestionAnswer;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.entity.Student;
import com.great.cms.enums.QuestionType;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.QuestionAnswerService;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;

@Controller
@RequestMapping("/student/quiz")
public class StudentQuizAnswerController {

	@Autowired
	QuizService quizService;

	@Autowired
	QuestionService questionService;
	@Autowired
	CourseRegistrationService courseRegService;
	@Autowired
	QuizRegistrationService quizRegService;
	@Autowired
	QuestionAnswerService questionAnsService;

	@RequestMapping("/answer/{quizId}")
	public String showQuizQuestionAnswerSheet(@PathVariable Long quizId,
			Model uiModel, RedirectAttributes redirectAttr) {
		System.out.println("student/quiz/answer");
		Student student = UserUtil.getInstance().getStudent();
		QuizRegistration quizReg = quizRegService
				.getQuizRegistrationByStudentAndQuiz(student, quizId);
		uiModel.addAttribute("quizRegistration", quizReg);
		
		if (quizReg.getIsAttended() == true) {
			redirectAttr.addAttribute("quizId", quizId);
			return "redirect:/student/quiz/view/{quizId}";
		}
		
		return "student/quiz/quiz_answer_sheet";
	}

	@RequestMapping(value = "/answer/save", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveQuizQuestionAnswers(
			StudentQuestionAnswers studentQuestionAnswers) {
		System.out.println("student/quiz/answer/save");
		System.out.println(studentQuestionAnswers);
		System.out.println("Quiz Registration Accessing!");
		QuizRegistration quizReg = quizRegService
				.getQuizRegistrationById(studentQuestionAnswers
						.getQuizRegistrationId().getQuizRegistrationId());

		if (quizReg.getIsAttended() == true) {
			return HttpStatus.SC_EXPECTATION_FAILED;
		}

		System.out.println("Quiz Registration Accessed!" + quizReg);

		System.out.println("delete All Method Started");
		questionAnsService.deleteAllByQuizRegistration(quizReg);
		System.out.println("delete All Method Ended");

		List<QuestionAnswer> questionAnswers = studentQuestionAnswers
				.getQuestionAnswers();
		System.out.println("Submitted Question Answer Size: "
				+ questionAnswers.size());

		for (QuestionAnswer questionAnswer : questionAnswers) {
			Question question = questionService.findById(questionAnswer
					.getQuestionId().getQuestionId());

			// System.out.println(question);
			// System.out.println(questionAnswer);

			boolean result = false;
			if (question.getQuestionType() == QuestionType.MCQ) {
				result = QuestionAnswerSimulatorUtil.getInstance()
						.isMCQAnswerCorrect(question, questionAnswer);
			} else if (question.getQuestionType() == QuestionType.FILL_IN_THE_GAPS) {
				result = QuestionAnswerSimulatorUtil.getInstance()
						.isFillInTheGapsAnswerCorrect(question, questionAnswer);
			}
			if (result == true) {
				System.out.println("[CORRECT] QID: " + question.getQuestionId()
						+ " Type: " + question.getQuestionType());
				questionAnswer.setMarks(question.getQuestionMarks());
			}
			questionAnsService.saveOrUpdate(questionAnswer);
		}
		quizReg.setSubmitTime(new Date());
		quizReg.setIsAttended(true);
		quizRegService.saveOrUpdate(quizReg);

		return HttpStatus.SC_ACCEPTED;
	}

	@RequestMapping("/ans")
	public String showAnsPage(Principal principal, Model uiModel) {

		return "student/quiz/std_ans";
	}
}
