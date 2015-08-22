package com.great.cms.dao;

import com.great.cms.entity.Teacher;
import com.great.cms.entity.User;

public interface TeacherDao extends GenericDao<Teacher, Long> {

	public Teacher getTeacherByUserId(User userId);

}
