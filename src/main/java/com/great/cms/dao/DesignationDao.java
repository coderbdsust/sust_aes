package com.great.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.great.cms.entity.Designation;


public interface DesignationDao extends GenericDao<Designation,Integer> {

	public void deleteAll();

}
