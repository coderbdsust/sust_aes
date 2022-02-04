package com.great.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.QuestionDao;
import com.great.cms.entity.Course;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.service.QuestionService;

@Service("QuestionService")
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	public void saveOrUpdate(Question question) {
		if (question.getQuestionId() == null) {
			questionDao.save(question);
		} else {
			questionDao.update(question);
		}
	}

	@Override
	public List<Question> findAll() {
		return questionDao.findAll();
	}

	@Override
	public Question findByCreationTimeAndCourseId(Date createdTime, Course courseId) {
		return questionDao.findByCreatedTimeAndCourseId(createdTime, courseId);
	}

	@Override
	public List<Question> findAvailableQuestions(Quiz quiz) {
		return questionDao.findAvailableQuestions(quiz);
	}

	@Override
	public List<Question> findAssignedQuestions(Quiz quiz) {
		return questionDao.findAssignedQuestions(quiz);
	}

	@Override
	public Question findById(Long id) {
		return questionDao.findById(id);
	}

}
