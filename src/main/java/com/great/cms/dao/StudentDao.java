package com.great.cms.dao;

import com.great.cms.entity.Student;
import com.great.cms.entity.User;


public interface StudentDao extends GenericDao<Student, Long> {

	Student findByRegId(Integer regId);

	Student getStudentByUserId(User userId);

}
