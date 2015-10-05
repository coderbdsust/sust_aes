package com.great.cms.utils.editor;

import java.beans.PropertyEditorSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.great.cms.enums.QuestionType;

public class QuestionEditor extends PropertyEditorSupport {

	private static final Logger log = LoggerFactory
			.getLogger(QuestionEditor.class);

	@Override
	public void setAsText(String text) {
		for (QuestionType type : QuestionType.values()) {
			System.out.println(type);
			if (type.name().equalsIgnoreCase(text)) {
				setValue(type);
				break;
			}
		}
	}

	@Override
	public String getAsText() {
		log.info("QuestionEditor value ={}", getValue());
		return String.valueOf(getValue());
	}
}
