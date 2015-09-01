package com.great.cms.dao;

import java.util.List;

import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;


public interface CourseRegistrationDao extends GenericDao<CourseRegistration, Integer>{

	List<CourseRegistration> findByCourseId(Course course);

}
