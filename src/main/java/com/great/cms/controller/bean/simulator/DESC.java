package com.great.cms.controller.bean.simulator;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
@JsonTypeName("desc")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType")
public class DESC implements IQuestion {

	@JsonProperty
	private IOption descAnswer;

	public DESC() {
		super();
	}

	@JsonCreator
	public DESC(@JsonProperty("descAnswer") IOption descAnswer) {
		super();
		this.descAnswer = descAnswer;
	}

	public IOption getdescAnswer() {
		return descAnswer;
	}

	public void setdescAnswer(IOption descAnswer) {
		this.descAnswer = descAnswer;
	}

	@Override
	public String toString() {
		return "DESC [descAnswer=" + descAnswer + "]";
	}

}
