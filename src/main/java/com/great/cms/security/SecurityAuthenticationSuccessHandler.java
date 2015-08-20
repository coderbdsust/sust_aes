package com.great.cms.security;

import com.great.cms.enums.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class SecurityAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {
	private static final Logger log = LoggerFactory
			.getLogger(SecurityAuthenticationSuccessHandler.class);

	public SecurityAuthenticationSuccessHandler() {
		System.out.println("Security Auth Success Created!");
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.debug("nAuthenticationSuccess()");

		System.out.println("Authority Loading!");

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());
		System.out.print("ON AS ROLES: "+roles.size());
		for (String r : roles) {
			System.out.println("R: " + r);
		}

		if (roles.contains(Role.ROLE_ADMIN.name())) {
			log.debug("role admin found, redirecting to intake page");
			response.sendRedirect("admin/index");
		}
	}
}
