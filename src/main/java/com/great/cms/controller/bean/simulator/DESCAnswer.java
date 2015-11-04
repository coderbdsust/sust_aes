package com.great.cms.controller.bean.simulator;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
@JsonTypeName("descAnswer")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType")
public class DESCAnswer implements IOption {

	@JsonProperty
	private String answer;

	@JsonCreator
	public DESCAnswer() {
		super();
	}


	public DESCAnswer(@JsonProperty("answer")String answer) {
		super();
		this.answer = answer;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "DESCAnswer [answer=" + answer + "]";
	}
	
	
}
