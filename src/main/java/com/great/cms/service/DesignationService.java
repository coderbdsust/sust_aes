package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.Designation;

public interface DesignationService {
	
	public void saveOrUpdateDesignation(Designation designation);

	public List<Designation> getDesignations();

	public void deleteDesignation(Designation designation);

	public Designation getDesignationById(Integer desgId);

	public void deleteAllDesignation();

}
