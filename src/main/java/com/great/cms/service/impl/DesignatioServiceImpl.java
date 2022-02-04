package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.DesignationDao;
import com.great.cms.entity.Designation;
import com.great.cms.service.DesignationService;

@Service("DesignationService")
public class DesignatioServiceImpl implements DesignationService {

	@Autowired
	DesignationDao designationDao;

	@Override
	public void saveOrUpdateDesignation(Designation designation) {
		if (designation.getDesigId() == null) {
			designationDao.save(designation);
		} else {
			designationDao.update(designation);
		}

	}

	@Override
	public List<Designation> getDesignations() {
		return designationDao.findAll();
	}

	@Override
	public void deleteDesignation(Designation designation) {
		designationDao.delete(designation);
	}

	@Override
	public Designation getDesignationById(Integer desgId) {
		return designationDao.findById(desgId);
	}

	@Override
	public void deleteAllDesignation() {
		designationDao.deleteAll();

	}

}
