package com.great.cms.controller.bean.simulator;

import java.util.List;

public class FIG implements IQuestion {

	private List<IOption> questionBody;

	public List<IOption> getQuestionBody() {
		return questionBody;
	}

	public void setQuestionBody(List<IOption> questionBody) {
		this.questionBody = questionBody;
	}

}
