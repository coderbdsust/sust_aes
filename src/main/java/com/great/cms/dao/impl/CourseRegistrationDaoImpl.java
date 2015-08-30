package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.CourseDao;
import com.great.cms.dao.CourseRegistrationDao;
import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;

@Repository
public class CourseRegistrationDaoImpl extends
		GenericDaoImpl<CourseRegistration, Integer> implements
		CourseRegistrationDao {
	
	public CourseRegistrationDaoImpl() {
		super(CourseRegistration.class);
	}
}
