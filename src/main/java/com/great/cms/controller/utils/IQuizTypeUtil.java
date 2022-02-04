package com.great.cms.controller.utils;

import java.util.Date;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.enums.QuizParticipationType;
import com.great.cms.enums.QuizRegistrationType;
import com.great.cms.enums.QuizStatusType;

public interface IQuizTypeUtil {

	public QuizRegistrationType getQuizRegistrationType(QuizRegistration quizReg);

	public QuizParticipationType getQuizParticipationType(QuizRegistration quizReg, Date currDate,
			QuizRegistrationType quizRegistrationType);

	public QuizStatusType getQuizStatusType(Date startDate, Date endDate, Date currDate);

	public QuizStatusType getQuizStatusType(Quiz quiz, Date currDate);

}
