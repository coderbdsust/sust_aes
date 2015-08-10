package com.great.cms.dao;



import java.util.List;

import com.great.cms.entity.User;


public interface UserDao extends GenericDao<User, Long>{
	
	public void deleteAll();
	public boolean usernameExists(String username);
	public User getActiveUser(String username, String password);
	public List<User> findActiveUsers();
}
