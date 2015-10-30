package com.great.cms.controller.bean;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;

public class StudentQuiz {
	private Quiz quiz;
	private QuizRegistration quizRegistration;

	public StudentQuiz() {
	}
	
	

	public StudentQuiz(Quiz quiz, QuizRegistration quizRegistration) {
		super();
		this.quiz = quiz;
		this.quizRegistration = quizRegistration;
	}



	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public QuizRegistration getQuizRegistration() {
		return quizRegistration;
	}

	public void setQuizRegistration(QuizRegistration quizRegistration) {
		this.quizRegistration = quizRegistration;
	}

	@Override
	public String toString() {
		return "StudentQuiz [quiz=" + quiz + ", quizRegistration="
				+ quizRegistration + "]";
	}

	

}
