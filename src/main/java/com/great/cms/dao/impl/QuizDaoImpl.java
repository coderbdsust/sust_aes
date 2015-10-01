package com.great.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.QuizDao;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teaches;



@Repository("QuizDao")
public class QuizDaoImpl extends GenericDaoImpl<Quiz, Long> implements QuizDao {

	public QuizDaoImpl() {
		super(Quiz.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Quiz> findByTeachesId(Teaches teachesId) {
		// TODO Auto-generated method stub
		return null;
	}

	



}
