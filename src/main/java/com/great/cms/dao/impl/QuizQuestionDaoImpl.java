package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.QuizQuestionDao;
import com.great.cms.entity.QuizQuestion;

@Repository("QuizQuestionDao")
public class QuizQuestionDaoImpl  extends GenericDaoImpl<QuizQuestion, Long> implements QuizQuestionDao {

	public QuizQuestionDaoImpl() {
		super(QuizQuestion.class);
		// TODO Auto-generated constructor stub
	}

}
