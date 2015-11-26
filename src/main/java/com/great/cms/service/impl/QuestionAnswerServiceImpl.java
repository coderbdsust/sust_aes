package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.QuestionAnswerDao;
import com.great.cms.entity.QuestionAnswer;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.service.QuestionAnswerService;

@Service("QuestionAnswerService")
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

	@Autowired
	QuestionAnswerDao questionAnsDao;

	@Override
	public void saveOrUpdate(QuestionAnswer questionAnswer) {
		// TODO Auto-generated method stub
		if (questionAnswer.getQuestionAnsId() == null) {
			questionAnsDao.save(questionAnswer);
		} else {
			questionAnsDao.update(questionAnswer);
		}
	}

	@Override
	public void deleteAllByQuizRegistration(QuizRegistration quizRegistrationId) {
		// TODO Auto-generated method stub
		questionAnsDao.deleteAllByQuizRegistration(quizRegistrationId);

	}

	@Override
	public QuestionAnswer getQuestionAnswer(Long questionAnsId) {
		// TODO Auto-generated method stub
		return questionAnsDao.findById(questionAnsId);
	}

	@Override
	public List<QuestionAnswer> getQuestionAnswersByQuizRegistration(
			QuizRegistration quizRegistrationId) {
		// TODO Auto-generated method stub
		return questionAnsDao.findAllByQuizRegistrationId(quizRegistrationId);
	}

}
