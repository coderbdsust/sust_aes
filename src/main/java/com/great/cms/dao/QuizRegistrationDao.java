package com.great.cms.dao;

import java.util.List;

import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;

public interface QuizRegistrationDao extends GenericDao<QuizRegistration, Long> {

	QuizRegistration findQuizRegistrationByCourseReg(Quiz quiz,
			CourseRegistration courseRegistration);

	List<QuizRegistration> findQuizRegistrationsByQuiz(Quiz quiz);
	
	List<QuizRegistration> findQuizRegistrationsByAttendedAndCourseRegistration(CourseRegistration courseRegistration);

	

}
