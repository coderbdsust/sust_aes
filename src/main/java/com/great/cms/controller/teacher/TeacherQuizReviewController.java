package com.great.cms.controller.teacher;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.controller.utils.IQuizTypeUtil;
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
@RequestMapping("/teacher/quiz")
public class TeacherQuizReviewController {

	@Autowired
	TeachesService teachesService;
	@Autowired
	QuizService quizService;
	@Autowired
	QuestionService questionService;

	@RequestMapping("/review/{id}")
	public String showStdReviewQuestions(@PathVariable Long id, Model uiModel,
			RedirectAttributes redirectAttr) {
		System.out.println("/teacher/quiz/review");
		Quiz quiz = quizService.getQuiz(id);
		if (QuizTypeUtil.getInstance().getQuizStatusType(quiz, new Date()) != QuizStatusType.Finished) {
			redirectAttr.addAttribute("id", quiz.getQuizId());
			return "redirect:/quiz/view/{id}";
		}
		List<Question> questionList = questionService
				.findAssignedQuestions(quiz);
		for(Question q:questionList){
			System.out.print(q.getQuestionId()+" ");
		}
		System.out.println("");
		uiModel.addAttribute("questionList", questionList);

		return "teacher/review/quiz_review";
	}
}
