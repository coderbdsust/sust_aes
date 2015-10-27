package com.great.cms.dao;

import java.util.List;

import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Student;


public interface CourseRegistrationDao extends GenericDao<CourseRegistration, Integer>{

	List<CourseRegistration> findByCourseId(Course course);
	public List<CourseRegistration> findByIsApproved(Student student);

}
