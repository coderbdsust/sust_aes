package com.great.cms.controller.utils;

import java.util.*;

import com.great.cms.entity.Question;
import com.great.cms.entity.QuestionAnswer;

public class QuestionUtil {

	private static final QuestionUtil ownInstance = new QuestionUtil();

	public static QuestionUtil getInstance() {
		return ownInstance;
	}

	public int getTotalMarks(List<Question> assignedQuestions) {
		int totalMarks = 0;
		for (Question q : assignedQuestions) {
			totalMarks += q.getQuestionMarks();
		}
		return totalMarks;
	}

	public int countTotalQuestions(List<Question> assignedQuestions) {
		return assignedQuestions.size();
	}
	
	public int getObtainMarks(List<QuestionAnswer> questionAnswers){
		int totalMarks=0;
		for(QuestionAnswer qa:questionAnswers){
			totalMarks+=qa.getMarks();
		}
		return totalMarks;
	}

}
