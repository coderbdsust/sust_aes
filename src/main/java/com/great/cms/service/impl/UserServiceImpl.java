package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.UserDao;
import com.great.cms.entity.User;
import com.great.cms.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public List<User> getUsers() {
		return userDao.findAll();
	}
	
	public User getUserById(Long id) {
		return userDao.findById(id);
	}

	public void saveOrUpdate(User user) {
		if (user.getUserId() != null) {
			userDao.save(user);
		}else{
			userDao.update(user);
		}
	}

	@Override
	public boolean usernameExists(String username) {
		return userDao.usernameExists(username);
	}
	
	public void deleteAll(){
		userDao.deleteAll();
	}

	@Override
	public User getActiveUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getActiveUser(username,password);
	}


	@Override
	public List<User> getActiveUsers() {
		// TODO Auto-generated method stub
		return userDao.findActiveUsers();
	}
	
}
