package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.UserRole;




public interface UserRoleService {

	
	public UserRole getUserRole(Integer userTypeId);
	
	public List<UserRole> getUserRoles();
	
	public void saveUserType(UserRole UserRole);
	
	public void deleteUserType(UserRole UserRole);
	
}
