package com.great.cms.dao;

import java.util.List;

import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizQuestion;

public interface QuizQuestionDao extends GenericDao<QuizQuestion, Long> {

	public List<QuizQuestion> getQuizQuestions(Quiz quizId);

}
