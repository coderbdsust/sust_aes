package com.great.cms.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.dao.DepartmentDao;
import com.great.cms.dao.QuizDao;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teaches;

import static org.junit.Assert.*;

@ContextConfiguration("file:src/main/webapp/WEB-INF/sustaes-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class QuizDaoTest {

	@Autowired
	QuizDao testDao;

	@Test
	public void runTest() {

		Quiz quiz = new Quiz();
		quiz.setQuizId(1L);
		quiz.setQuizTitle("Database Quize 1");
		quiz.setCreateDate(new Date());
		quiz.setUpdateDate(new Date());
		quiz.setStartTime(new Date());
		quiz.setEndTime(new Date());
		quiz.setIsQuestionTimerOn(true);
		Teaches teaches = new Teaches();
		teaches.setTeachesId(1);
		quiz.setTeachesId(teaches);
		quiz.setDescription("Final Database Quize");
		System.out.println(quiz);
		testDao.save(quiz);

		List<Quiz> tests = testDao.findAll();
		System.out.println(tests.get(0));
		assertEquals(1, tests.size());

	}

}
