package com.great.cms.service;

import java.util.Date;
import java.util.List;

import com.great.cms.entity.Course;
import com.great.cms.entity.Question;

public interface QuestionService {
	
	public void saveOrUpdate(Question question);
	public List<Question> findAll();
	public Question findByCreationTimeAndCourseId(Date createdTime, Course courseId);

}
