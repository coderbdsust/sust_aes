package com.great.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.UserDao;
import com.great.cms.entity.User;

@Repository("UserDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public void deleteAll() {
		this.em.createQuery("delete FROM User").executeUpdate();
	}

	@Override
	public boolean usernameExists(String username) {
		Query query = this.em
				.createQuery("SELECT u from User u where u.username=:username");
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		if (users == null || users.isEmpty() || users.size() > 1)
			return false;
		return true;
	}

	@Override
	public User findByUsername(String username) {
		Query query = this.em
				.createQuery("SELECT u FROM User u WHERE u.username=:username");
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		if (users == null || users.isEmpty() || users.size() > 1)
			return null;
		return users.get(0);
	}

	public Long countUsers() {
		Query query = this.em
				.createQuery("SELECT count(u) FROM User u WHERE u.enabled=true");
		Long count = (Long) query.getResultList().get(0);
		return count;
	}

	public Integer countVerificationNeed() {
		Query query = this.em.createQuery("SELECT u FROM User u WHERE "
				+ "u.enabled=false " + "or u.accountNonLocked=false "
				+ "or u.accountNonExpired=false "
				+ "or u.credentialsNonExpired=false");
		Integer count = query.getResultList().size();
		return count;
	}

	public List<User> nonVerifiedUsers() {
		Query query = this.em.createQuery("SELECT u FROM User u WHERE "
				+ "u.enabled=false " + "or u.accountNonLocked=false "
				+ "or u.accountNonExpired=false "
				+ "or u.credentialsNonExpired=false");
		return query.getResultList();
	}

	@Override
	public void deleteUserAllRoles(User user) {
		Query query = this.em
				.createQuery("delete FROM UserRole u where u.userId=:userId");
		query.setParameter("userId", user);
		query.executeUpdate();
	}

}
