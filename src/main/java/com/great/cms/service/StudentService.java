package com.great.cms.service;



import com.great.cms.entity.Student;
import com.great.cms.entity.User;

public interface StudentService {
	public void saveOrUpdateStudent(Student student);
	public Student getStudentByRegId(Integer regId);
	public Student getStudentById(Long studentId);
	public Student getStudentByUserId(User userId);

}
