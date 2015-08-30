package com.great.cms.security.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public final class SimpleGrantedAuthority implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4024604707182393169L;
	private final String role;

	public SimpleGrantedAuthority(String role) {
		Assert.hasText(role,
				"A granted authority textual representation is required");
		this.role = role;
	}

	public String getAuthority() {
		return role;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SimpleGrantedAuthority) {
			return role.equals(((SimpleGrantedAuthority) obj).role);
		}

		return false;
	}

	public int hashCode() {
		return this.role.hashCode();
	}

	public String toString() {
		return this.role;
	}

}
