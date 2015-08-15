package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.StudentDao;
import com.great.cms.entity.Student;



@Repository("StudentDao")
public class StudentDaoImpl extends GenericDaoImpl<Student, Integer> implements StudentDao  {
	
	public StudentDaoImpl(){
		super(Student.class);
	}
}
