package com.great.cms.service;

import java.util.Date;
import java.util.List;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teaches;

public interface QuizService {
	public void saveOrUpdate(Quiz quiz);
	public Quiz getQuiz(Long quizId);
	public List<Quiz> getQuizes(Teaches teachesId);
	public Quiz getQuizesByCreateDateAndTeachesId(Date createDate, Teaches teachesId);
}
