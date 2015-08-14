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
		if (user.getUserId() == null) {
			userDao.save(user);
		} else {
			userDao.update(user);
		}
	}

	@Override
	public boolean usernameExists(String username) {
		return userDao.usernameExists(username);
	}

	public void deleteAll() {
		userDao.deleteAll();
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	public Integer countVerifiedUsers() {
		return userDao.countUsers();
	}

	public Integer countVerificationNeed() {
		return userDao.countVerificationNeed();
	}

	@Override
	public List<User> nonVerifiedUsers() {
		// TODO Auto-generated method stub
		return userDao.nonVerifiedUsers();
	}

}
