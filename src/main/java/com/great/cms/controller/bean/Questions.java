package com.great.cms.controller.bean;

import java.util.ArrayList;
import java.util.List;

import com.great.cms.entity.QuizQuestion;

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

	public List<QuizQuestion> getFilteredQuizQuestions() {
		ArrayList<QuizQuestion> newQuizQuestions = new ArrayList<QuizQuestion>();
		for (QuizQuestion q : this.quizQuestions) {
			if (null != q.getQuizId() && null != q.getQuestionId()) {
				newQuizQuestions.add(q);
			}
		}
		return newQuizQuestions;
	}

	public void setQuizQuestions(List<QuizQuestion> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}

	@Override
	public String toString() {
		return "Questions [quizId=" + quizId + ", quizQuestions=" + quizQuestions + "]";
	}

}
