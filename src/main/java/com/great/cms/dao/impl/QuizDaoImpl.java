package com.great.cms.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.QuizDao;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teaches;

@Repository("QuizDao")
public class QuizDaoImpl extends GenericDaoImpl<Quiz, Long> implements QuizDao {

	public QuizDaoImpl() {
		super(Quiz.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Quiz findByCreateDateAndTeachesId(Date createDate, Teaches teachesId) {
		Query query = this.em.createQuery("SELECT q FROM Quiz q WHERE"
				+ " q.createDate=:createDate and q.teachesId=:teachesId");

		query.setParameter("createDate", createDate);
		query.setParameter("teachesId", teachesId);

		@SuppressWarnings("unchecked")
		List<Quiz> quizes = query.getResultList();
		if (quizes == null || quizes.isEmpty() || quizes.size() > 1)
			return null;

		return quizes.get(0);
	}

	public List<Quiz> findByTeachesId(Teaches teachesId) {
		Query query = this.em.createQuery("SELECT q FROM Quiz q WHERE"
				+ " q.teachesId=:teachesId");

		query.setParameter("teachesId", teachesId);

		List<Quiz> quizes = query.getResultList();
		return quizes;
	}

}
