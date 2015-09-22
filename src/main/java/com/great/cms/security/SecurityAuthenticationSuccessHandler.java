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
		System.out.println("Security Authentication Success Handler!");
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.debug("nAuthenticationSuccess()");

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());

		System.out.println("#ROLES : " + roles.size());

		if (roles.contains(Role.ROLE_ADMIN.name())) {
			log.debug("role admin found, redirecting...");
			System.out.println("ROLE: ADMIN FOUND, REDIRECTING...");
			response.sendRedirect("admin/index");
		} else if (roles.contains(Role.ROLE_TEACHER.name())) {
			log.debug("role teacher found, redirecting...");
			System.out.println("ROLE: TEACHER FOUND, REDIRECTING...");
			response.sendRedirect("teacher/profile/");
		} else if (roles.contains(Role.ROLE_STUDENT.name())) {
			log.debug("role student found, redirecting...");
			System.out.println("ROLE: STUDENT FOUND, REDIRECTING...");
			response.sendRedirect("student/exam/dashboard");
		}
	}
}
