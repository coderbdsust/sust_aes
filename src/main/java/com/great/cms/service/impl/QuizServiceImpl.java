package com.great.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.QuizDao;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.Student;
import com.great.cms.entity.Teaches;
import com.great.cms.service.QuizService;

@Service("QuizService")
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDao quizDao;

	public void saveOrUpdate(Quiz quiz) {
		if (quiz.getQuizId() == null) {
			quizDao.save(quiz);
		} else {
			quizDao.update(quiz);
		}
	}

	public Quiz getQuiz(Long quizId) {
		return quizDao.findById(quizId);

	}

	public List<Quiz> getQuizes(Teaches teachesId) {
		return quizDao.findByTeachesId(teachesId);

	}

	@Override
	public Quiz getQuizesByCreateDateAndTeachesId(Date createDate, Teaches teachesId) {
		return quizDao.findByCreateDateAndTeachesId(createDate, teachesId);
	}

	@Override
	public void delete(Long id) {
		quizDao.deleteById(id);
	}

	@Override
	public List<Quiz> getAvailableQuizzes(Student studentId) {
		return quizDao.findNewAvaialableQuizByStudentId(studentId);
	}
}
