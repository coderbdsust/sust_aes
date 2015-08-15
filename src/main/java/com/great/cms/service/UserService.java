package com.great.cms.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.great.cms.entity.User;


public interface UserService {
	public List<User> getUsers();
	public User getUserById(Long id);
	public User getUser(String username);
	public void saveOrUpdate(User user);
	public boolean usernameExists(String username);
	public Long countVerifiedUsers();
	public Integer countVerificationNeed();
	public List<User> nonVerifiedUsers();
	
}
