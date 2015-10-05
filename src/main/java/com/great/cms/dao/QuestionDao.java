package com.great.cms.dao;

import java.util.Date;

import com.great.cms.entity.Course;
import com.great.cms.entity.Question;

public interface QuestionDao extends GenericDao<Question, Long> {

	public Question findByCreatedTimeAndCourseId(Date createdTime, Course courseId);

}
