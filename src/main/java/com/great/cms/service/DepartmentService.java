package com.great.cms.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.great.cms.entity.Department;


public interface DepartmentService {
	public void saveOrUpdateDepartment(Department dept);
	public Department getDepartment(Integer deptId);
	public List<Department> getDepartments();
	public void deleteDepartment(Department dept);
	public void deleteAllDepartment();
}
