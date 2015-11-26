package com.great.cms.controller.bean;

import java.util.ArrayList;
import java.util.List;

import com.great.cms.entity.QuizQuestion;

/**
 * @author Biswajit Debnath 1. Change the class name to ExamQuesion or
 *         ExamDetail 2. I think it's preferable to use Quiz quizId instead of
 *         Long quizId 3. ExamDetail(Quiz quiz, List<QuizQuestion>
 *         quizQuestions)
 */
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
		return "Questions [quizId=" + quizId + ", quizQuestions="
				+ quizQuestions + "]";
	}

}
