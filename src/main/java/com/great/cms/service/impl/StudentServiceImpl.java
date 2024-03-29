package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.StudentDao;
import com.great.cms.entity.Student;
import com.great.cms.entity.User;
import com.great.cms.service.StudentService;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	public void saveOrUpdateStudent(Student student) {
		Student prevStudent = studentDao.findById(student.getStudentId());
		if (prevStudent == null) {
			studentDao.save(student);
		} else {
			studentDao.update(student);
		}
	}

	public Student getStudentById(Long studentId) {
		return studentDao.findById(studentId);
	}

	public Student getStudentByRegId(Integer regId) {
		return studentDao.findByRegId(regId);
	}

	@Override
	public Student getStudentByUserId(User userId) {
		return studentDao.getStudentByUserId(userId);
	}

	@Override
	public List<Student> getStudents() {
		return studentDao.findAll();
	}

}
