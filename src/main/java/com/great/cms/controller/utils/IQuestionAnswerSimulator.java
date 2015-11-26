package com.great.cms.controller.utils;

import com.great.cms.entity.Question;
import com.great.cms.entity.QuestionAnswer;

public interface IQuestionAnswerSimulator {
	public boolean isMCQAnswerCorrect(Question question, QuestionAnswer questionAnswer);
	public boolean isFillInTheGapsAnswerCorrect(Question question, QuestionAnswer questionAnswer);

}
