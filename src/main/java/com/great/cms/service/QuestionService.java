package com.great.cms.service;

import java.util.Date;
import java.util.List;

import com.great.cms.entity.Course;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;

public interface QuestionService {

	public void saveOrUpdate(Question question);

	public List<Question> findAll();

	public Question findByCreationTimeAndCourseId(Date createdTime,
			Course courseId);

	public List<Question> findAvailableQuestions(Quiz quiz);

	public List<Question> findAssignedQuestions(Quiz quiz);
	
	public Question findById(Long id);

}
