package com.great.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.great.cms.entity.Student;


public interface StudentDao extends GenericDao<Student, Long> {

	Student findByRegId(Integer regId);

	Student getStudentByUserId(Long userId);

}
