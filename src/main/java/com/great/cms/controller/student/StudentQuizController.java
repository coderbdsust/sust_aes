package com.great.cms.controller.student;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.controller.bean.StudentQuiz;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.entity.Student;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;



@Controller
@RequestMapping("/student/quiz")
public class StudentQuizController {
	
	@Autowired
	CourseRegistrationService courseRegService;
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizRegistrationService quizRegistrationService;
	
	
	@RequestMapping("/answer")
	public String showExamQuestions(Principal principal, Model uiModel) {
		System.out.println("student/quiz/answer");
		
//		Student student = UserUtil.getInstance().getStudent(principal);
//		List<Quiz> quizzes  = quizService.getAvailableQuizzes(student);
//		List<StudentQuiz> studentQuizzees=new ArrayList<StudentQuiz>();
//		
//		for(Quiz quiz: quizzes){
//			StudentQuiz stdQuiz = new StudentQuiz();
//		}
		
		return "student/quiz/quiz_answer_sheet";
	}
	
	@RequestMapping("/dashboard")
	public String showStdExamDashboard(Principal principal, Model uiModel) {
		System.out.println("student/quiz/dashboard");
		
		return "student/quiz/std_quiz_dashboard";
	}
	
	@RequestMapping("/view")
	public String showStdExamView(Model model) {
		System.out.println("/quiz/question");
		return "student/quiz/std_quiz_view";
	}

}
