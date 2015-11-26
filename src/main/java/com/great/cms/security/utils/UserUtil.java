package com.great.cms.security.utils;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import com.great.cms.entity.Student;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.User;
import com.great.cms.service.StudentService;
import com.great.cms.service.TeacherService;
import com.great.cms.service.UserService;

public class UserUtil {

	private static final UserUtil ownInstance = new UserUtil();

	@Autowired
	private UserService userService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;

	public static UserUtil getInstance() {
		return ownInstance;
	}

	public Teacher getTeacher() {
		User user = userService.getCurrentLoggedInUser();
		Teacher teacher = teacherService.getTeacherByUserId(user);
		if (teacher == null) {
			teacher = new Teacher();
		}
		teacher.setUserId(user);
		return teacher;
	}

	public Teacher getTeacher(Principal principal) {
		User user = userService.getUser(principal.getName());
		Teacher teacher = teacherService.getTeacherByUserId(user);
		if (teacher == null) {
			teacher = new Teacher();
		}
		teacher.setUserId(user);
		return teacher;
	}

	public Student getStudent() {
		User user = userService.getCurrentLoggedInUser();
		Student student = studentService.getStudentByUserId(user);
		if (student == null) {
			student = new Student();
		}
		student.setUserId(user);
		return student;
	}

	public Student getStudent(Principal principal) {
		User user = userService.getUser(principal.getName());
		Student student = studentService.getStudentByUserId(user);
		if (student == null) {
			student = new Student();
		}
		student.setUserId(user);
		return student;
	}
}