package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.TeacherDao;
import com.great.cms.dao.UserDao;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.User;

@Repository("TeacherDao")
public class TeacherDaoImpl extends GenericDaoImpl<Teacher, Long> implements TeacherDao  {
	
	public TeacherDaoImpl(){
		super(Teacher.class);
	}
}
