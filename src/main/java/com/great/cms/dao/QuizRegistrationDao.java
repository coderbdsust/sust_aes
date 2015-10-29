package com.great.cms.dao;

import java.util.List;

import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.User;

public interface QuizRegistrationDao extends GenericDao<QuizRegistration, Long> {

	QuizRegistration findQuizRegByCourseReg(
			CourseRegistration courseRegistration);

	List<QuizRegistration> findQuizRegsByQuiz(Quiz quiz);

	

}
