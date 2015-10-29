package com.great.cms.controller.bean;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;

public class StudentQuiz {
	private Quiz quiz;
	private QuizRegistration quizReg;

	public StudentQuiz() {
	}

	public StudentQuiz(Quiz quiz, QuizRegistration quizReg) {
		this.quiz = quiz;
		this.quizReg = quizReg;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public QuizRegistration getQuizReg() {
		return quizReg;
	}

	public void setQuizReg(QuizRegistration quizReg) {
		this.quizReg = quizReg;
	}

	@Override
	public String toString() {
		return "StudentQuiz [quiz=" + quiz + ", quizReg=" + quizReg + "]";
	}

}
