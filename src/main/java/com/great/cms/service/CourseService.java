package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.Course;


public interface CourseService {
	
	public void saveOrUpdate(Course course);

	public Course findById(Integer id);
	
	public List<Course> getCourses();
	
	public void deleteCourse(Course course);


	
}
