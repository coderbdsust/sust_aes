package com.great.cms.controller.bean;

import java.util.ArrayList;

import com.great.cms.entity.QuestionAnswer;
import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;

public class StudentQuestionAnswers {

	private QuizRegistration quizRegistrationId = new QuizRegistration();
	private ArrayList<QuestionAnswer> questionAnswers = new ArrayList<>();

	public StudentQuestionAnswers() {
	}

	public StudentQuestionAnswers(QuizRegistration quizRegistrationId, ArrayList<QuestionAnswer> questionAnswers) {
		this.quizRegistrationId = quizRegistrationId;
		this.questionAnswers = questionAnswers;
	}

	public QuizRegistration getQuizRegistrationId() {
		return quizRegistrationId;
	}

	public void setQuizRegistrationId(QuizRegistration quizRegistrationId) {
		this.quizRegistrationId = quizRegistrationId;
	}

	public ArrayList<QuestionAnswer> getQuestionAnswers() {
		return questionAnswers;
	}

	public void setQuestionAnswers(ArrayList<QuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}

	@Override
	public String toString() {
		return "StudentQuestionAnswers [quizRegistrationId=" + quizRegistrationId + ", questionAnswers="
				+ questionAnswers + "]";
	}

}
