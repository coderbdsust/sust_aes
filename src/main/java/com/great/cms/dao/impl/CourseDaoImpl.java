package com.great.cms.dao.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.great.cms.dao.CourseDao;
import com.great.cms.dao.GenericDao;
import com.great.cms.entity.Course;

@Repository("CourseDao")
public class CourseDaoImpl extends GenericDaoImpl<Course, Integer> implements CourseDao{

	public CourseDaoImpl () {
		super(Course.class );
	}

}
