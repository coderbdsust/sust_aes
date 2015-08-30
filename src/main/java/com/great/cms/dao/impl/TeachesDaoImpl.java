package com.great.cms.dao.impl;

import com.great.cms.dao.TeachesDao;
import com.great.cms.entity.Teaches;

public class TeachesDaoImpl extends GenericDaoImpl<Teaches, Integer> implements
		TeachesDao {

	public TeachesDaoImpl() {
		super(Teaches.class);
	}

}
