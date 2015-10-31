package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizQuestion;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.entity.Teacher;

public interface QuizRegistrationService {

	public void saveOrUpdate(QuizRegistration quizReg);

	public QuizRegistration getQuizRegistrationByCourseReg(Quiz quiz,
			CourseRegistration courseRegistration);

	public List<QuizRegistration> getQuizRegistrationsByQuiz(Quiz quiz);

	public List<QuizRegistration> getQuizRegistrationsByAttendedAndCourseReg(
			List<CourseRegistration> courseRegistrations);

}
