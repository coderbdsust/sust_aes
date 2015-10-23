package com.great.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.QuizQuestionDao;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizQuestion;

@Repository("QuizQuestionDao")
public class QuizQuestionDaoImpl extends GenericDaoImpl<QuizQuestion, Long>
		implements QuizQuestionDao {

	public QuizQuestionDaoImpl() {
		super(QuizQuestion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<QuizQuestion> getQuizQuestions(Quiz quizId) {
		Query query = this.em.createQuery("SELECT q FROM QuizQuestion q WHERE"
				+ " q.quizId=:quizId");
		query.setParameter("quizId", quizId);
		List<QuizQuestion> quizQuestions = query.getResultList();
		return quizQuestions;
	}

	@Override
	public void deleteQuizQuestion(Quiz quizId, Question questionId) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("DELETE FROM q QuizQuestion q WHERE"
				+ " q.quizId=:quizId and q.questionId=:questionId");
		query.setParameter("quizId", quizId);
		query.setParameter("questionId", questionId);
		
		
		query.executeUpdate();
		
	}

}
