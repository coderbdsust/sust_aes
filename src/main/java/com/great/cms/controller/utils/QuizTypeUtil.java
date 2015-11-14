package com.great.cms.controller.utils;

import java.util.Date;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.QuizRegistration;
import com.great.cms.enums.QuizStatusType;
import com.great.cms.enums.QuizParticipationType;
import com.great.cms.enums.QuizRegistrationType;

public class QuizTypeUtil implements IQuizTypeUtil {

	private static final IQuizTypeUtil ownInstance = new QuizTypeUtil();

	public static IQuizTypeUtil getInstance() {
		return ownInstance;
	}

	public QuizRegistrationType getQuizRegistrationType(QuizRegistration quizReg) {
		if (quizReg == null) {
			return QuizRegistrationType.APPLY;
		} else if (quizReg.getIsRegApproved() == false) {
			return QuizRegistrationType.PENDING;
		}
		return QuizRegistrationType.APPROVED;
	}

	public QuizParticipationType getQuizParticipationType(
			QuizRegistration quizReg, Date currDate) {
		// TODO Auto-generated method stub
		if (quizReg == null) {
			return QuizParticipationType.CAN_NOT_PARTICIPATE;
		} else if (getQuizStatusType(quizReg.getQuizId(), currDate) == QuizStatusType.Running
				&& quizReg.getIsAttended() == false) {
			return QuizParticipationType.CAN_PARTICIPATE;
		}
		return QuizParticipationType.CAN_NOT_PARTICIPATE;
	}

	public QuizStatusType getQuizStatusType(Date startDate, Date endDate,
			Date currDate) {

		if (currDate.after(startDate) && currDate.before(endDate)) {
			return QuizStatusType.Running;
		} else if (currDate.before(startDate) && currDate.before(endDate)) {
			return QuizStatusType.Upcoming;
		} else {
			return QuizStatusType.Finished;
		}
	}

	public QuizStatusType getQuizStatusType(Quiz quiz, Date currDate) {
		if (currDate == null) {
			currDate = new Date();
		}
		return getQuizStatusType(quiz.getStartTime(), quiz.getEndTime(),
				currDate);
	}
}
