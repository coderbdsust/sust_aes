package com.great.cms.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.great.cms.controller.AdminController;
import com.great.cms.dao.UserDao;
import com.great.cms.entity.User;
import com.great.cms.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

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
		return userDao.findByUsername(username);
	}

	@Override
	public Long countVerifiedUsers() {
		return userDao.countUsers();
	}

	public Integer countVerificationNeed() {
		return userDao.countVerificationNeed();
	}

	@Override
	public List<User> nonVerifiedUsers() {
		return userDao.nonVerifiedUsers();
	}

	@Override
	public void deleteUserRoles(User user) {
		userDao.deleteUserAllRoles(user);

	}

	@Override
	public User getCurrentLoggedInUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.debug("getCurrentLoggedInUser() => {" + user.getUsername() + "}, id={" + user.getUserId() + "}");
		return userDao.findById(user.getUserId());
	}

}
