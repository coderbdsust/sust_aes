package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.QuizDao;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teaches;
import com.great.cms.service.QuizService;

@Service("QuizService")
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDao quizDao;

	public void saveOrUpdateTest(Quiz quiz) {
		if (quiz.getQuizId() == null) {
			quizDao.save(quiz);
		} else {
			quizDao.update(quiz);
		}
	}

	public List<Quiz> getQuizes(Teaches teachesId) {
		return quizDao.findByTeachesId(teachesId);

	}
}
