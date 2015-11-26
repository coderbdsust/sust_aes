package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.Department;


public interface DepartmentService {
	public void saveOrUpdateDepartment(Department dept);
	public Department getDepartmentById(Integer deptId);
	public List<Department> getDepartments();
	public void deleteDepartment(Department dept);
	public void deleteAllDepartment();
}
