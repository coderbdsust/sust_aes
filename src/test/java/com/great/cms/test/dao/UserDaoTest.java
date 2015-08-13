package com.great.cms.test.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.dao.UserDao;
import com.great.cms.dao.UserRoleDao;
import com.great.cms.entity.User;
import com.great.cms.entity.UserRole;
import com.great.cms.enums.Role;
import com.mchange.util.AssertException;

@ContextConfiguration("file:src/main/webapp/WEB-INF/sustaes-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;

	
//	@Test
//	public void saveUser() {
//		
//		userDao.deleteAll();
//		User user = new User();
//		
//		user.setUsername("coder_bd");
//		user.setPassword("abcd123");
//		user.setAccountNonExpired(true);
//		user.setAccountNonLocked(true);
//		user.setCredentialsNonExpired(true);
//		user.setEnabled(true);
//
//		
//		System.out.println("Saving user!");
//		userDao.save(user);
//		System.out.println("User saved!");
//
//
//
//		List<User> users  = userDao.findAll();
//		for(User u:users){
//			System.out.println(u);
//		}
//		assertEquals(1, users.size());
//		
//		boolean result  = userDao.usernameExists("coder_bd");
//		assertEquals(true, result);
//		
//		User us = userDao.findByUsernameActive(user.getUsername());
//		System.out.println(us);
//		assertNotNull(us);
//		
//		List<User> activeUsers = userDao.findActiveUsers();
//		assertEquals(1, activeUsers.size());
//		for(User u:activeUsers){
//			System.out.println(u);
//		}
//	}
	
	@Test
	public void userCheck(){
//		List<User> users  = userDao.findAll();
//		System.out.println(users);
		
		User user = userDao.findByUsername("coder_bd");
		System.out.println(user);
		assertNotNull(user);
	}
	
	

}
