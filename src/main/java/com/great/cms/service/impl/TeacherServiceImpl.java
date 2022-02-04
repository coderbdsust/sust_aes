package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.TeacherDao;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.User;
import com.great.cms.service.TeacherService;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;

	public void saveOrUpdateTeacher(Teacher teacher) {
		Teacher prevTeacher = teacherDao.findById(teacher.getInstructorId());
		if (prevTeacher == null) {
			teacherDao.save(teacher);
		} else {
			teacherDao.update(teacher);
		}
	}

	@Override
	public Teacher getTeacher(Long instructorId) {
		return teacherDao.findById(instructorId);
	}

	@Override
	public Teacher getTeacherByUserId(User userId) {
		return teacherDao.getTeacherByUserId(userId);
	}

	@Override
	public List<Teacher> getTeachers() {
		return teacherDao.findAll();
	}

}
