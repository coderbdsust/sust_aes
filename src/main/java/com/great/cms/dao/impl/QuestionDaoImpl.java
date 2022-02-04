package com.great.cms.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.QuestionDao;
import com.great.cms.entity.Course;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;

@Repository("QuestionDao")
public class QuestionDaoImpl extends GenericDaoImpl<Question, Long> implements
		QuestionDao {

	public QuestionDaoImpl() {
		super(Question.class);
	}

	@Override
	public Question findByCreatedTimeAndCourseId(Date createdTime,
			Course courseId) {
		Query query = this.em.createQuery("SELECT q FROM Question q WHERE"
				+ " q.createdTime=:createdTime and q.courseId=:courseId");

		query.setParameter("createdTime", createdTime);
		query.setParameter("courseId", courseId);

		@SuppressWarnings("unchecked")
		List<Question> questions = query.getResultList();
		if (questions == null || questions.isEmpty() || questions.size() > 1)
			return null;
		return questions.get(0);
	}

	@Override
	public List<Question> findAssignedQuestions(Quiz quiz) {
		Query query = this.em
				.createQuery("SELECT q FROM Question q WHERE q.questionId in (SELECT qq.questionId FROM QuizQuestion qq where qq.quizId=:quizId)");
		query.setParameter("quizId", quiz);
		return query.getResultList();
	}

	@Override
	public List<Question> findAvailableQuestions(Quiz quiz) {
		Query query = this.em
				.createQuery("SELECT q FROM Question q WHERE"
						+ " q.questionId not in (SELECT qq.questionId FROM QuizQuestion qq where qq.quizId=:quizId)");
		query.setParameter("quizId", quiz);
		return query.getResultList();
	}
}
