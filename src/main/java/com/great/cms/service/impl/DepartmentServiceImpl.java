package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.DepartmentDao;
import com.great.cms.entity.Department;
import com.great.cms.service.DepartmentService;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao;

	public void saveOrUpdateDepartment(Department dept) {
		if (dept.getDeptId() == null) {
			departmentDao.save(dept);
		} else {
			departmentDao.update(dept);
		}
	}

	@Override
	public Department getDepartmentById(Integer deptId) {
		return departmentDao.findById(deptId);
	}

	@Override
	public List<Department> getDepartments() {
		return departmentDao.findAll();
	}

	@Override
	public void deleteDepartment(Department dept) {
		departmentDao.delete(dept);
	}
	
	@Override
	public void deleteAllDepartment() {
		departmentDao.deleteAll();
	}

}
