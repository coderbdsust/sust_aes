package com.great.cms.security;

import com.great.cms.entity.User;
import com.great.cms.enums.Role;
import com.great.cms.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;



public class DatabaseAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public DatabaseAuthenticationProvider() {
		// TODO Auto-generated constructor stub
		System.out.println("Database Authentication Provider Initialize!");
	}

	@Autowired
	private UserService userService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// ignored
		System.out.println("Add Auth Cheeks!");
	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		logger.debug("retrieveUser()  username ={}", username);
		
		System.out.println("User Details");

		System.out.println("Username:" + username);
		String password = (String) authentication.getCredentials();
		System.out.println("Password: " + password);

		if (!StringUtils.hasText(password)) {
			throw new BadCredentialsException("Please enter password");
		}

		try {
			User targetUser = (User) userService.getUser(username);
			System.out.println(targetUser);
			if (!password.equals(targetUser.getPassword())) {
				throw new BadCredentialsException("Invalid Password");
			}
			System.out.println("Authentication Checking! , TargetUser: "
					+ targetUser);
			return targetUser;

		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			throw new BadCredentialsException("Invalid user");
		}
	}
}
