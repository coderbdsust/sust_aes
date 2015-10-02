package com.great.cms.security;

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

	public Teacher getTeacher(String username) {
		System.out.println(userService == null ? "UserService Not Intialized"
				: "User Service Autowired");

		User user = userService.getUser(username);
//		System.out.println(user);
		Teacher teacher = teacherService.getTeacherByUserId(user);
//		System.out.println(teacher);
		if (teacher == null) {
			teacher = new Teacher();
		}
		teacher.setUserId(user);
		return teacher;
	}

	public Student getStudent(String username) {

		System.out.println(userService == null ? "UserService Not Intialized"
				: "User Service Autowired");

		User user = userService.getUser(username);
		Student student = studentService.getStudentByUserId(user);
		if (student == null) {
			student = new Student();
		}
		student.setUserId(user);
		return student;
	}
}