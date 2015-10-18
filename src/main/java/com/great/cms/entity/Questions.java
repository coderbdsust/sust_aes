package com.great.cms.entity;

import java.util.ArrayList;
import java.util.List;

public class Questions {

	public Long quizId;
	List<QuizQuestion> quizQuestions = new ArrayList<>();

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public List<QuizQuestion> getQuizQuestions() {
		return quizQuestions;
	}

	public void setQuizQuestions(List<QuizQuestion> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}

	@Override
	public String toString() {
		return "Questions [quizId=" + quizId + ", quizQuestions=" + quizQuestions + "]";
	}
	

}
