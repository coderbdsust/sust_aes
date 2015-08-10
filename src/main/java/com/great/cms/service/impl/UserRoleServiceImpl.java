package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.UserRoleDao;
import com.great.cms.entity.UserRole;
import com.great.cms.service.UserRoleService;


@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userTypeDao;

	@Override
	public UserRole getUserRole(Integer userTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRole> getUserRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUserType(UserRole UserRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserType(UserRole UserRole) {
		// TODO Auto-generated method stub
		
	}

	

}
