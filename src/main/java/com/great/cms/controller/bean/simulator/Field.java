package com.great.cms.controller.bean.simulator;

public class Field implements IOption, Comparable<Field> {
	private Integer index;
	private String answer;

	public Field() {
	}

	public Field(Integer index, String answer) {
		this.index = index;
		this.answer = answer;
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

	@Override
	public String toString() {
		return "Field [index=" + index + ", answer=" + answer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
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
		Field other = (Field) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.replaceAll("\\s+", "").equalsIgnoreCase(
				other.answer.replaceAll("\\s+", "")))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		return true;
	}

	@Override
	public int compareTo(Field o) {
		// TODO Auto-generated method stub
		return this.index - o.getIndex();
	}

}
