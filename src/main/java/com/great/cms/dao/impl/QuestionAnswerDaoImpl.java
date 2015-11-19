package com.great.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.QuestionAnswerDao;
import com.great.cms.entity.Department;
import com.great.cms.entity.QuestionAnswer;
import com.great.cms.entity.QuizRegistration;

@Repository("QuestionAnswerDao")
public class QuestionAnswerDaoImpl extends GenericDaoImpl<QuestionAnswer, Long>
		implements QuestionAnswerDao {

	public QuestionAnswerDaoImpl() {
		super(QuestionAnswer.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deleteAllByQuizRegistration(
			QuizRegistration quizRegistrationId) {
		System.out.println(quizRegistrationId.getQuizRegistrationId()==null?"QUIZ REG ID NULL":"QUIZ REG ID OK");
		try {
			Query query = this.em.createQuery("delete QuestionAnswer "
					+ " where quizRegistrationId=:quizRegistrationId");
			query.setParameter("quizRegistrationId", quizRegistrationId);
			System.out.println("DELETE QUERY: " + query);
			query.executeUpdate();
			System.out.println("[EXECUTED] : QuestionAnswer Deleted");
		} catch (Exception ex) {
			System.out.println("[EXCEPTION] : QuestionAnswer Not Deleted");
		}

	}

	@Override
	public List<QuestionAnswer> findAllByQuizRegistrationId(
			QuizRegistration quizRegistrationId) {
		// TODO Auto-generated method stub
		List<QuestionAnswer> questionAnswerList = null;

		try {
			Query query = this.em.createQuery("SELECT qa FROM QuestionAnswer qa "
					+ "where qa.quizRegistrationId=:quizRegistrationId");
			query.setParameter("quizRegistrationId", quizRegistrationId);
			questionAnswerList = query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return questionAnswerList;
	}

}
