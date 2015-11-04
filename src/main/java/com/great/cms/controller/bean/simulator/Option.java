package com.great.cms.controller.bean.simulator;

public class Option implements IOption{
	private Integer index;
	private String text;
	private boolean answer;

	public Option() {
	}

	public Option(Integer index, String text, boolean answer) {
		this.index = index;
		this.text = text;
		this.answer = answer;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Option [index=" + index + ", text=" + text + ", answer="
				+ answer + "]";
	}

}
