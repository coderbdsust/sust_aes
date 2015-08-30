package com.great.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.UserRoleDao;
import com.great.cms.entity.UserRole;


@Repository("UserRoleDao")
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole, Long> implements UserRoleDao {

	public UserRoleDaoImpl(Class<UserRole> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public UserRoleDaoImpl() {
		super(UserRole.class);
		// TODO Auto-generated constructor stub
	}

	

}
