package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Student;

public interface CourseRegistrationService {

	public void saveOrUpdate(CourseRegistration courseRegistration);

	public List<CourseRegistration> getCourseRegistrations();

	public List<CourseRegistration> findByCourseId(Course course);

	public List<CourseRegistration> findByStudentAndIsApproved(Student studentId);

	public CourseRegistration findByStudentAndCourseAndIsApproved(
			Student student, Course course);
}
