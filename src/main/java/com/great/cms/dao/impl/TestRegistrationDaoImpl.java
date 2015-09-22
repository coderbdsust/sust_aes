package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.TestRegistrationDao;
import com.great.cms.entity.TestRegistration;

@Repository("TestRegistrationDao")
public class TestRegistrationDaoImpl extends
		GenericDaoImpl<TestRegistration, Long> implements TestRegistrationDao {

	public TestRegistrationDaoImpl() {
		super(TestRegistration.class);
	}

}
