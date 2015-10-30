package com.great.cms.controller.utils;

import java.util.*;

import com.great.cms.entity.Question;

public class QuestionUtil {
	
	private static final QuestionUtil ownInstance = new QuestionUtil();
	
	public static QuestionUtil getInstance(){
		return ownInstance;
	}
	
	public int getTotalMarks(List<Question> assignedQuestions){
		int totalMarks=0;
		for(Question q:assignedQuestions){
			totalMarks+=q.getQuestionMarks();
		}
		return totalMarks;
	}
	
	public int countTotalQuestions(List<Question> assignedQuestions){
		return assignedQuestions.size();
	}
	

}
