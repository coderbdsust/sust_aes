package com.great.cms.controller.student;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.entity.Student;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.QuestionService;
import com.great.cms.service.QuizRegistrationService;
import com.great.cms.service.QuizService;

@Controller
@RequestMapping("/student/quiz")
public class StudentQuizDashboardController {

	@Autowired
	CourseRegistrationService courseRegService;

	@Autowired
	QuizService quizService;

	@Autowired
	QuestionService questionService;

	@Autowired
	QuizRegistrationService quizRegistrationService;

	@RequestMapping("/dashboard")
	public String showStdExamDashboard( Model uiModel) {
		System.out.println("student/quiz/dashboard");
		Student student = UserUtil.getInstance().getStudent();
		
		if(student.getStudentId()==null){
			return "redirect:/student/profile";
		}
		
		List<CourseRegistration> courseRegistrationList = courseRegService
				.findByStudentAndIsApproved(student);
		List<Quiz> quizList = quizService.getAvailableQuizzes(student);
		List<QuizRegistration> reviewableQuizRegList = quizRegistrationService
				.getQuizRegistrationsByAttendedAndCourseReg(courseRegistrationList);
		
		uiModel.addAttribute("quizList", quizList);
		uiModel.addAttribute("reviewableQuizRegistrationList",
				reviewableQuizRegList);
		uiModel.addAttribute("courseRegistrationList", courseRegistrationList);
		return "student/quiz/std_quiz_dashboard";
	}

}
