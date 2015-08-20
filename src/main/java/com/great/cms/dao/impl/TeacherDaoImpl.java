package com.great.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

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

	@Override
	public Teacher getTeacherByUserId(Long userId) {
		Query query = this.em
				.createQuery("SELECT t FROM Teacher t WHERE t.userId=:userId");
		query.setParameter("userId", userId);
		List<Teacher> teachers = query.getResultList();
		if (teachers == null || teachers.isEmpty() || teachers.size() > 1)
			return null;
		
		return teachers.get(0);
	}
}
