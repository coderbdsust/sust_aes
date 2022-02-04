package com.great.cms.controller.student;

import java.security.Principal;
import java.util.Date;
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

import com.great.cms.controller.bean.StudentQuestionAnswers;
import com.great.cms.controller.utils.QuestionAnswerSimulatorUtil;
import com.great.cms.entity.Question;
import com.great.cms.entity.QuestionAnswer;
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
	
	private static final Logger log = LoggerFactory.getLogger(StudentQuizAnswerController.class);

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
		log.debug("GET: /");
		Student student = UserUtil.getInstance().getStudent();
		QuizRegistration quizReg = quizRegService
				.getQuizRegistrationByStudentAndQuiz(student, quizId);
		uiModel.addAttribute("quizRegistration", quizReg);
		if (quizReg.getIsAttended() == true) {
			log.debug("GET: /student/quiz/answer");
			redirectAttr.addAttribute("quizId", quizId);
			return "redirect:/student/quiz/view/{quizId}";
		}
		log.debug("GET: /student/quiz/answer");
		return "student/quiz/quiz_answer_sheet";
	}

	@RequestMapping(value = "/answer/save", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveQuizQuestionAnswers(
			StudentQuestionAnswers studentQuestionAnswers) {
		log.debug("POST: /");
		log.debug("Student Question Ans: "+studentQuestionAnswers);
		QuizRegistration quizReg = quizRegService
				.getQuizRegistrationById(studentQuestionAnswers
						.getQuizRegistrationId().getQuizRegistrationId());

		if (quizReg.getIsAttended() == true) {
			return HttpStatus.SC_EXPECTATION_FAILED;
		}

		log.debug("Quiz Registration Accessed!" + quizReg);

		questionAnsService.deleteAllByQuizRegistration(quizReg);

		List<QuestionAnswer> questionAnswers = studentQuestionAnswers
				.getQuestionAnswers();
		log.debug("Submitted Question Answer Size : " + questionAnswers.size());

		for (QuestionAnswer questionAnswer : questionAnswers) {
			Question question = questionService.findById(questionAnswer
					.getQuestionId().getQuestionId());
			
			boolean result = false;
			
			if (question.getQuestionType() == QuestionType.MCQ) {
				result = QuestionAnswerSimulatorUtil.getInstance()
						.isMCQAnswerCorrect(question, questionAnswer);
				questionAnswer.setAnsReviewed(true);
			} else if (question.getQuestionType() == QuestionType.FILL_IN_THE_GAPS) {
				result = QuestionAnswerSimulatorUtil.getInstance()
						.isFillInTheGapsAnswerCorrect(question, questionAnswer);
				questionAnswer.setAnsReviewed(true);
			}
			
			if (result == true) {
				log.debug("[CORRECT] QID: " + question.getQuestionId() + " Type: " + question.getQuestionType());
				questionAnswer.setMarks(question.getQuestionMarks());
			}
			questionAnsService.saveOrUpdate(questionAnswer);
		}
		quizReg.setSubmitTime(new Date());
		quizReg.setIsAttended(true);
		quizRegService.saveOrUpdate(quizReg);
		log.debug("POST: /student/quiz/answer/save");
		return HttpStatus.SC_ACCEPTED;
	}

	@RequestMapping("/ans")
	public String showAnsPage(Principal principal, Model uiModel) {
		log.debug("GET: /");
		log.debug("GET: /student/quiz/ans");
		return "student/quiz/std_ans";
	}
}
