package com.great.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.dao.CourseRegistrationDao;
import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Student;
import com.great.cms.entity.Teaches;

@Repository
public class CourseRegistrationDaoImpl extends GenericDaoImpl<CourseRegistration, Integer>
		implements CourseRegistrationDao {

	public CourseRegistrationDaoImpl() {
		super(CourseRegistration.class);
	}

	@Override
	public List<CourseRegistration> findByCourseId(Course course) {
		Query query = this.em.createQuery("SELECT cr FROM CourseRegistration cr WHERE cr.courseId=:courseId");
		query.setParameter("courseId", course);
		List<CourseRegistration> courseRegList = query.getResultList();
		return courseRegList;
	}

	@Override
	@Transactional(readOnly = true, value = "transactionManager")
	public List<CourseRegistration> findByStudentAndIsApproved(Student student) {
		Query query = this.em.createQuery(
				"SELECT cr FROM CourseRegistration cr WHERE cr.isApproved=true and cr.studentId=:studentId");
		query.setParameter("studentId", student);
		List<CourseRegistration> courseRegList = query.getResultList();
		for (CourseRegistration courseRegistration : courseRegList) {
			System.out.println(courseRegistration.getCourseId().getTeachesList().size());
		}
		return courseRegList;
	}
}
