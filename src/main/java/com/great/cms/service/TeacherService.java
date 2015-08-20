package com.great.cms.service;

import org.springframework.stereotype.Component;

import com.great.cms.entity.Teacher;


public interface TeacherService {
	public void saveOrUpdateTeacher(Teacher teacher);
	public Teacher getTeacher(Long instructorId);
	public Teacher getTeacherByUserId(Long userId);
}
