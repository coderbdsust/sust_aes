package com.great.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.StudentDao;
import com.great.cms.entity.Student;
import com.great.cms.entity.Teacher;

@Repository("StudentDao")
public class StudentDaoImpl extends GenericDaoImpl<Student, Long> implements
		StudentDao {

	public StudentDaoImpl() {
		super(Student.class);
	}

	@Override
	public Student findByRegId(Integer regId) {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("SELECT s from Student s where registrationNo=:regNo");
		query.setParameter("regNo", regId);
		List<Student> students = query.getResultList();
		if (students != null && students.size() > 1)
			return null;
		return students.get(0);
	}

	@Override
	public Student getStudentByUserId(Long userId) {
		Query query = this.em
				.createQuery("SELECT s FROM Student s WHERE s.userId=:userId");
		query.setParameter("userId", userId);
		List<Student> students = query.getResultList();
		if (students == null || students.isEmpty() || students.size() > 1)
			return null;
		return students.get(0);
	}
}
