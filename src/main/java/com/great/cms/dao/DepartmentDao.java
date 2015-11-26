package com.great.cms.dao;

import com.great.cms.entity.Department;


public interface DepartmentDao  extends GenericDao<Department, Integer> {

	public void deleteAll();

}
