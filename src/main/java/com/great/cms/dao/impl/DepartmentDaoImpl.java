package com.great.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.great.cms.dao.CourseDao;
import com.great.cms.dao.DepartmentDao;
import com.great.cms.entity.Course;
import com.great.cms.entity.Department;

public class DepartmentDaoImpl extends GenericDaoImpl<Department, Integer>
		implements DepartmentDao {

	public DepartmentDaoImpl() {
		super(Department.class);

	}

	@Override
	public void deleteAll() {
		Query query = this.em.createQuery("delete d from department d");
		query.executeUpdate();
	}

}
