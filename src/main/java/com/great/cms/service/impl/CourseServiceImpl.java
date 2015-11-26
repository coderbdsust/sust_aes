package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.CourseDao;
import com.great.cms.entity.Course;
import com.great.cms.service.CourseService;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

	public void saveOrUpdate(Course course) {
		if (course.getCourseId() == null)
			courseDao.save(course);
		else {
			courseDao.update(course);
		}
	}

	public Course findById(Integer id) {
		return courseDao.findById(id);
	}

	public void deleteCourse(Course course) {
		courseDao.delete(course);
	}
	
	public List<Course> getCourses(){
		return courseDao.findAll();
	}

}
