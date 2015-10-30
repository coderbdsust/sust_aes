package com.great.cms.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.dao.CourseRegistrationDao;
import com.great.cms.dao.QuizDao;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Student;
import com.great.cms.service.QuizService;


@ContextConfiguration("file:src/main/webapp/WEB-INF/sustaes-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CourseRegistrationDaoTest {
	
	@Autowired
	CourseRegistrationDao courseRegDao;
	@Autowired
	QuizDao quizDao;
	
	
	@Test
	public void runTest(){
		Student student  = new Student(2L);
		List<CourseRegistration> courseRegs = courseRegDao.findByStudentAndIsApproved(student);
		System.out.println(courseRegs.size());
		for(CourseRegistration cr:courseRegs){
			System.out.println(cr.getCourseRegId()+" "+cr.getIsApproved());
			assertNotNull(cr);
		}
	
	
	}

}
