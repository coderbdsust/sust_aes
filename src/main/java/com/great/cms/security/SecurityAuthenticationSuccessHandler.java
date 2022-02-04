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

public class SecurityAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger log = LoggerFactory.getLogger(SecurityAuthenticationSuccessHandler.class);

	public SecurityAuthenticationSuccessHandler() {
		log.debug("Security authentication success handler!");
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.debug("/");
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		log.debug("#Roles : " + roles.size());
		if (roles.contains(Role.ROLE_ADMIN.name())) {
			log.debug("Role: Admin Found, redirecting...");
			response.sendRedirect("admin/index");
		} else if (roles.contains(Role.ROLE_TEACHER.name())) {
			log.debug("Role: Teacher Found, redirecting...");
			response.sendRedirect("teacher/profile/");
		} else if (roles.contains(Role.ROLE_STUDENT.name())) {
			log.debug("Role: Student Found, redirecting...");
			response.sendRedirect("student/quiz/dashboard");
		}
	}
}
