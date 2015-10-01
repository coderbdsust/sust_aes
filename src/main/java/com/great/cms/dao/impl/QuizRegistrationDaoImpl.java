package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.QuizRegistrationDao;
import com.great.cms.entity.QuizRegistration;


@Repository("QuizRegistrationDao")
public class QuizRegistrationDaoImpl extends
		GenericDaoImpl<QuizRegistration, Long> implements QuizRegistrationDao {

	public QuizRegistrationDaoImpl() {
		super(QuizRegistration.class);
	}

}
