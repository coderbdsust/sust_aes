package com.great.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.great.cms.dao.StudentDao;
import com.great.cms.entity.Student;
import com.great.cms.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	
	@Autowired StudentDao studentDao;
	
	public void saveStudent(Student student){
		studentDao.save(student);
	}

}
