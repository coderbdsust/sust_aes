package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.TestDao;
import com.great.cms.entity.Test;

@Repository("TestDao")
public class TestDaoImpl extends GenericDaoImpl<Test, Long> implements TestDao {

	public TestDaoImpl() {
		super(Test.class);
		// TODO Auto-generated constructor stub
	}

}
