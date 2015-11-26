package com.great.cms.service;

import java.util.Date;
import java.util.List;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.Student;
import com.great.cms.entity.Teaches;

public interface QuizService {
	public void saveOrUpdate(Quiz quiz);
	public Quiz getQuiz(Long quizId);
	public List<Quiz> getQuizes(Teaches teachesId);
	public List<Quiz> getAvailableQuizzes(Student studentId);
	public Quiz getQuizesByCreateDateAndTeachesId(Date createDate, Teaches teachesId);
	public void delete(Long id);
}
