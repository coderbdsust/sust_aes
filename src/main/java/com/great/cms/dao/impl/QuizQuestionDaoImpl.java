package com.great.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.QuizDao;
import com.great.cms.dao.QuizQuestionDao;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teaches;



@Repository("QuizQuestionDao")
public class QuizQuestionDaoImpl extends GenericDaoImpl<Question, Long> implements QuizQuestionDao {

	public QuizQuestionDaoImpl() {
		super(Question.class);
		// TODO Auto-generated constructor stub
	}

}
