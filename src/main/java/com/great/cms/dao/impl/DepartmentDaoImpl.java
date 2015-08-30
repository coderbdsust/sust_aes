package com.great.cms.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.DepartmentDao;
import com.great.cms.entity.Department;

@Repository("DepartmentDao")
public class DepartmentDaoImpl extends GenericDaoImpl<Department, Integer>
		implements DepartmentDao {

	public DepartmentDaoImpl() {
		super(Department.class);

	}

	@Override
	public void deleteAll() {
		Query query = this.em.createQuery("DELETE FROM Department");
		query.executeUpdate();
	}

}
