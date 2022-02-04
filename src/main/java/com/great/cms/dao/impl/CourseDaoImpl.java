package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.CourseDao;
import com.great.cms.entity.Course;

@Repository("CourseDao")
public class CourseDaoImpl extends GenericDaoImpl<Course, Integer> implements CourseDao {

	public CourseDaoImpl() {
		super(Course.class);
	}

}
