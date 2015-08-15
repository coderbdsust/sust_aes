package com.great.cms.utils.editor;

import java.beans.PropertyEditorSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.great.cms.enums.Role;

public class RoleEditor extends PropertyEditorSupport {
	private static final Logger log = LoggerFactory.getLogger(RoleEditor.class);

	@Override
	public void setAsText(String text) {
		for (Role authority : Role.values()) {
			System.out.println(authority);
			if (authority.name().equalsIgnoreCase(text)) {
				
				setValue(authority);
				break;
			}
		}
	}

	@Override
	public String getAsText() {
		log.info("RoleEditor value ={}", getValue());
		return String.valueOf(getValue());
	}
}
