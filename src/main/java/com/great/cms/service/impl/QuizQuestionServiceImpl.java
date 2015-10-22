package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.QuizQuestionDao;
import com.great.cms.entity.QuizQuestion;
import com.great.cms.service.QuizQuestionService;
@Service("quizQuestionService")
public class QuizQuestionServiceImpl implements QuizQuestionService {

	@Autowired
	private QuizQuestionDao quizQuestionDao;

	@Override
	public void saveOrUpdateQuizQuestion(QuizQuestion quizQuestion) {
		quizQuestionDao.save(quizQuestion);

	}

	@Override
	public QuizQuestion getQuizQuestion(Long quizQuestionId) {
		return quizQuestionDao.findById(quizQuestionId);
	}

	@Override
	public List<QuizQuestion> getQuizQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

}
