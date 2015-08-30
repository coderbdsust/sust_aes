package com.great.cms.dao;

import com.great.cms.entity.Designation;


public interface DesignationDao extends GenericDao<Designation,Integer> {

	public void deleteAll();

}
