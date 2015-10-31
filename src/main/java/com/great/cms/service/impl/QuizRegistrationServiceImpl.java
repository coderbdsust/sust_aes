package com.great.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.QuizRegistrationDao;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.service.QuizRegistrationService;

@Service("QuizRegistrationService")
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
	public QuizRegistration getQuizRegistrationByCourseReg(Quiz quiz,
			CourseRegistration courseRegistration) {
		return quizRegDao.findQuizRegistrationByCourseReg(quiz,
				courseRegistration);
	}

	@Override
	public List<QuizRegistration> getQuizRegistrationsByQuiz(Quiz quiz) {
		return quizRegDao.findQuizRegistrationsByQuiz(quiz);

	}

	@Override
	public List<QuizRegistration> getQuizRegistrationsByAttendedAndCourseReg(
			List<CourseRegistration> courseRegistrationList) {
		// TODO Auto-generated method stub
		List<QuizRegistration> quizRegList = new ArrayList<QuizRegistration>();
		for (CourseRegistration cr : courseRegistrationList) {
			List<QuizRegistration> quizRegs = quizRegDao
					.findQuizRegistrationsByAttendedAndCourseRegistration(cr);
			if (quizRegs != null && quizRegs.size() != 0)
				quizRegList.addAll(quizRegs);
		}
		return quizRegList;
	}
}
