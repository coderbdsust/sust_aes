package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.QuizQuestion;
import com.great.cms.entity.Teacher;

public interface QuizQuestionService {

	public void saveOrUpdateQuizQuestion(QuizQuestion quizQuestion);

	public QuizQuestion getQuizQuestion(Long quizQuestionId);

	public List<QuizQuestion> getQuizQuestions();

}
