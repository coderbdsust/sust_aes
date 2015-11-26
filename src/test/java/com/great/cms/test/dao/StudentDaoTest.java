package com.great.cms.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("file:src/main/webapp/WEB-INF/sustaes-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class StudentDaoTest {
	
	@Test
	public void runTest(){
		
	}

}
