package com.great.cms.service;

import com.great.cms.entity.Teacher;
import com.great.cms.entity.User;


public interface TeacherService {
	public void saveOrUpdateTeacher(Teacher teacher);
	public Teacher getTeacher(Long instructorId);
	public Teacher getTeacherByUserId(User user);
}
