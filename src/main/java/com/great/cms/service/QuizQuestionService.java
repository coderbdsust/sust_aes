package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.Question;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizQuestion;
import com.great.cms.entity.Teacher;

public interface QuizQuestionService {

	public void saveOrUpdate(QuizQuestion quizQuestion);

	public QuizQuestion getQuizQuestion(Long quizQuestionId);

	public List<QuizQuestion> getQuizQuestions(Quiz quizId);
	
	public void deleteById(Long Id);
	
	

}
