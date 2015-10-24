package com.great.cms.controller.bean.util;

import java.util.*;

import com.great.cms.entity.Question;

public class QuestionUtils {
	
	private static final QuestionUtils ownInstance = new QuestionUtils();
	
	public static QuestionUtils getInstance(){
		return ownInstance;
	}
	
	public int getTotalMarks(List<Question> assignedQuestions){
		int totalMarks=0;
		for(Question q:assignedQuestions){
			totalMarks+=q.getQuestionMarks();
		}
		return totalMarks;
	}
	
	public int getTotalQuestions(List<Question> assignedQuestions){
		return assignedQuestions.size();
	}
	

}
