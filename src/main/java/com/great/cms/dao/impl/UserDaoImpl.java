package com.great.cms.dao.impl;

import java.lang.annotation.Retention;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.dao.CourseDao;
import com.great.cms.dao.UserDao;
import com.great.cms.dao.UserRoleDao;
import com.great.cms.entity.Course;
import com.great.cms.entity.User;

@Repository("UserDao")
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	private Session getSession() {
		Session session = (Session) super.em.getDelegate();
		System.out.println(session);
		return session;
	}

	@Override
	public void deleteAll() {
		getSession().createQuery("delete FROM User").executeUpdate();

	}

	@Override
	public boolean usernameExists(String username) {
		Query query = getSession().createQuery(
				"FROM User u where u.username=:user");
		System.out.println("QUERY: " + username);
		query.setString("user", username);
		User user = (User) query.uniqueResult();
		System.out.println("UE: " + user);
		return user != null;

	}

	@Override
	public User getActiveUser(String username, String password) {

		Query query = getSession()
				.createQuery(
						"FROM User u where u.username=:user and u.password=:pass "
						+ "and u.accountNonLocked=:accNonLocked "
						+ "and u.accountNonExpired=:accNonExpired "
						+ "and u.credentialsNonExpired=:creNonExpired "
						+ "and u.enabled=:en");
		
		query.setString("user", username);
		query.setString("pass", password);
		query.setBoolean("accNonLocked", true);
		query.setBoolean("accNonExpired", true);
		query.setBoolean("creNonExpired", true);
		query.setBoolean("en", true);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public List<User> findActiveUsers() {
		Query query = getSession()
				.createQuery(
						"FROM User u where  u.accountNonLocked=:accountNonLocked and u.accountNonExpired=:accountNonExpired and u.credentialsNonExpired=:credentialsNonExpired and u.enabled=:enabled");
		query.setBoolean("accountNonLocked", true);
		query.setBoolean("accountNonExpired", true);
		query.setBoolean("credentialsNonExpired", true);
		query.setBoolean("enabled", true);
		List<User> users = query.list();
		return users;
	}

}
