package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.QuestionDao;
import com.great.cms.entity.Question;

@Repository("QuestionDao")
public class QuestionDaoImpl extends GenericDaoImpl<Question, Long> implements
		QuestionDao {

	public QuestionDaoImpl() {
		super(Question.class);
		// TODO Auto-generated constructor stub
	}
}
