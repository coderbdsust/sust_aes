package com.great.cms.dao.impl;

import com.great.cms.dao.DepartmentDao;
import com.great.cms.dao.DesignationDao;
import com.great.cms.entity.Department;
import com.great.cms.entity.Designation;

public class DesignationDaoImpl extends GenericDaoImpl<Designation, Integer>
		implements DesignationDao {

	public DesignationDaoImpl() {
		super(Designation.class);
	}

}
