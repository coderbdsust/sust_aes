package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.great.cms.dao.QuizRegistrationDao;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.service.QuizRegistrationService;

public class QuizRegistrationServiceImpl implements QuizRegistrationService {

	@Autowired
	QuizRegistrationDao quizRegDao;

	@Override
	public void saveOrUpdate(QuizRegistration quizReg) {
		if (null == quizReg.getQuizRegistrationId()) {
			quizRegDao.save(quizReg);
		} else {
			quizRegDao.update(quizReg);
		}

	}

	@Override
	public QuizRegistration getQuizRegistrationByCourseReg(
			CourseRegistration courseRegistration) {
		return quizRegDao.findQuizRegByCourseReg(courseRegistration);
	}

	@Override
	public List<QuizRegistration> getQuizRegistrationsByQuiz(Quiz quiz) {
		return quizRegDao.findQuizRegsByQuiz(quiz);
	
	}

}
