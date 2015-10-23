package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.QuizQuestionDao;
import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizQuestion;
import com.great.cms.service.QuizQuestionService;

@Service("quizQuestionService")
public class QuizQuestionServiceImpl implements QuizQuestionService {

	@Autowired
	private QuizQuestionDao quizQuestionDao;

	@Override
	public void saveOrUpdate(QuizQuestion quizQuestion) {
		if (null == quizQuestion.getQuizQuestionId()) {
			quizQuestionDao.save(quizQuestion);
		} else {
			quizQuestionDao.update(quizQuestion);
		}
	}

	@Override
	public QuizQuestion getQuizQuestion(Long quizQuestionId) {
		return quizQuestionDao.findById(quizQuestionId);
	}

	@Override
	public List<QuizQuestion> getQuizQuestions(Quiz quizId) {
		return quizQuestionDao.getQuizQuestions(quizId);
	}

	@Override
	public void deleteQuizQuestion(QuizQuestion quizQuestionId) {
		// TODO Auto-generated method stub
		quizQuestionDao.delete(quizQuestionId);
		
	}

	@Override
	public void deleteQuizQuestion(Quiz quizId, Question questionId) {
		// TODO Auto-generated method stub
		 quizQuestionDao.deleteQuizQuestion(quizId,questionId);
		
	}

}
