package com.great.cms.controller.bean.simulator;

public class Option implements IOption, Comparable<Option> {
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
		return "Option [index=" + index + ", text=" + text + ", answer=" + answer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (answer ? 1231 : 1237);
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Option other = (Option) obj;
		if (answer != other.answer)
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public int compareTo(Option o) {
		// TODO Auto-generated method stub
		return this.index - o.getIndex();
	}

}
