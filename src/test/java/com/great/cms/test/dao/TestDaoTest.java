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
import com.great.cms.dao.TestDao;
import com.great.cms.entity.Teaches;
import static org.junit.Assert.*;

@ContextConfiguration("file:src/main/webapp/WEB-INF/sustaes-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestDaoTest {

	@Autowired
	TestDao testDao;

	@Test
	public void runTest() {

		com.great.cms.entity.Test test = new com.great.cms.entity.Test();
		test.setTestId(1L);
		test.setTestTitle("Database Quize 1");
		test.setCreateDate(new Date());
		test.setUpdateDate(new Date());
		test.setStartTime(new Date());
		test.setEndTime(new Date());
		test.setIsQuestionTimerOn(true);
		Teaches teaches = new Teaches();
		teaches.setTeachesId(1);
		test.setTeachesId(teaches);
		test.setDescription("Final Database Quize");
		System.out.println(test);
		testDao.save(test);
		
		List<com.great.cms.entity.Test> tests = testDao.findAll();
		System.out.println(tests.get(0));
		assertEquals(1, tests.size());

	}

}
