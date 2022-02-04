package com.great.cms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.great.cms.entity.User;
import com.great.cms.service.UserService;

public class DatabaseAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private final Logger log = LoggerFactory.getLogger(getClass());

	public DatabaseAuthenticationProvider() {
		log.debug("Database Authentication Provider Initialize!");
	}

	@Autowired
	private UserService userService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		log.debug("Add Auth Cheeks " + userDetails);
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		log.debug("/");
		log.debug("Username:" + username);
		String password = (String) authentication.getCredentials();

		if (!StringUtils.hasText(username)) {
			throw new BadCredentialsException("Please enter username");
		}

		if (!StringUtils.hasText(password)) {
			throw new BadCredentialsException("Please enter password");
		}

		try {
			User targetUser = (User) userService.getUser(username);
			log.debug("Target User: " + targetUser);
			if (!password.equals(targetUser.getPassword())) {
				throw new BadCredentialsException("Invalid Password");
			}
			log.debug("Authentication Checking, TargetUser: " + targetUser);
			return targetUser;

		} catch (Exception ex) {
			log.error(ex.getLocalizedMessage());
			throw new BadCredentialsException("Invalid user");
		}
	}
}
