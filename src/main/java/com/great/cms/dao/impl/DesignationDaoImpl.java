package com.great.cms.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.DepartmentDao;
import com.great.cms.dao.DesignationDao;
import com.great.cms.entity.Department;
import com.great.cms.entity.Designation;


@Repository("DesignationDao")
public class DesignationDaoImpl extends GenericDaoImpl<Designation, Integer>
		implements DesignationDao {

	public DesignationDaoImpl() {
		super(Designation.class);
	}

	@Override
	public void deleteAll() {
		Query query = this.em.createQuery("delete  FROM Designation");
		query.executeUpdate();
		
	}

}
