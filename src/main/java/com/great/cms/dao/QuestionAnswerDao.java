package com.great.cms.dao;

import java.util.List;

import com.great.cms.entity.QuestionAnswer;
import com.great.cms.entity.QuizRegistration;

public interface QuestionAnswerDao extends GenericDao<QuestionAnswer, Long> {

	public List<QuestionAnswer> findAllByQuizRegistrationId(
			QuizRegistration quizRegistrationId);

	public void deleteAllByQuizRegistration(QuizRegistration quizRegistrationId);

}
