package com.great.cms.dao;

import java.util.Date;
import java.util.List;

import com.great.cms.entity.Course;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;

public interface QuestionDao extends GenericDao<Question, Long> {

	public Question findByCreatedTimeAndCourseId(Date createdTime, Course courseId);

	public List<Question> findAssignedQuestions(Quiz quiz);

	public List<Question> findAvailableQuestions(Quiz quiz);

}
