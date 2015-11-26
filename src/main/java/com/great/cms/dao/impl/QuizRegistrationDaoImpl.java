package com.great.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.dao.QuizRegistrationDao;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizQuestion;
import com.great.cms.entity.QuizRegistration;

@Repository("QuizRegistrationDao")

public class QuizRegistrationDaoImpl extends
		GenericDaoImpl<QuizRegistration, Long> implements QuizRegistrationDao {

	public QuizRegistrationDaoImpl() {
		super(QuizRegistration.class);
	}

	@Override
	@Transactional(readOnly = true, value = "transactionManager")
	public QuizRegistration findQuizRegistrationByCourseReg(Quiz quiz,
			CourseRegistration courseRegistration) {
		Query query = this.em
				.createQuery("SELECT qr FROM QuizRegistration qr WHERE"
						+ " qr.courseRegId=:courseRegId and qr.quizId=:quiz");
		query.setParameter("courseRegId", courseRegistration);
		query.setParameter("quiz", quiz);
		List<QuizRegistration> quizRegistrations = query.getResultList();
		if (null != quizRegistrations && quizRegistrations.size() == 1) {
			/*
			 * This line 
			 */
			quizRegistrations.get(0).getQuestionAnswerList().size();/*Line added for removing lazy exception*/
			return quizRegistrations.get(0);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true, value = "transactionManager")
	public List<QuizRegistration> findQuizRegistrationsByQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("SELECT qr FROM QuizRegistration qr WHERE"
						+ " qr.quizId=:quizId");
		query.setParameter("quizId", quiz);
		List<QuizRegistration> quizRegistrations = query.getResultList();
		for(QuizRegistration qr:quizRegistrations){
			/*Line added for removing lazy exception*/
			qr.getQuestionAnswerList().size();
		}
		return quizRegistrations;
	}

	@Override
	@Transactional(readOnly = true, value = "transactionManager")
	public List<QuizRegistration> findQuizRegistrationsByAttendedAndCourseRegistration(
			CourseRegistration courseRegistration) {
		Query query = this.em
				.createQuery("SELECT qr FROM QuizRegistration qr WHERE"
						+ " qr.courseRegId=:courseRegId and isRegApproved=true and isAttended=true");
		query.setParameter("courseRegId", courseRegistration);
		List<QuizRegistration> quizRegistrations = query.getResultList();
		for(QuizRegistration qr:quizRegistrations){
			/*Line added for removing lazy exception*/
			qr.getQuestionAnswerList().size();
		}
		return quizRegistrations;
	}

}
