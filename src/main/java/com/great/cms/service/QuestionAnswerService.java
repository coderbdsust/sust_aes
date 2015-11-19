package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.QuestionAnswer;
import com.great.cms.entity.QuizRegistration;

public interface QuestionAnswerService {
	public void saveOrUpdate(QuestionAnswer questionAnswer);
	public void deleteAllByQuizRegistration(QuizRegistration quizRegistrationId);
	public QuestionAnswer getQuestionAnswer(Long questionAnsId);
	public List<QuestionAnswer> getQuestionAnswersByQuizRegistration(QuizRegistration quizRegistrationId);

}
