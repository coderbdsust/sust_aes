package com.great.cms.enums;

public enum Role {
	ROLE_ADMIN("Admin"), ROLE_STUDENT("Student"), ROLE_TEACHER("Teacher");

	private String name;

	private Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
