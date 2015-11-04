package com.great.cms.controller.bean.simulator;

public class Field implements IOption {
	private Integer index;
	private String answer;

	public Field() {
	}

	public Field(Integer index, String answer) {
		this.index = index;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Field [index=" + index + ", answer=" + answer + "]";
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
