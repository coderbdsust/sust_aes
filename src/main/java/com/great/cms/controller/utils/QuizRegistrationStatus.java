package com.great.cms.controller.utils;

import com.great.cms.entity.QuizRegistration;
import com.great.cms.enums.RegistrationType;

public class QuizRegistrationStatus {

	public RegistrationType getQuizRegistrationStatus(QuizRegistration quizReg) {
		if (quizReg == null) {
			return RegistrationType.APPLY;
		} else if (quizReg.getIsRegApproved() == false) {
			return RegistrationType.PENDING;
		}
		return RegistrationType.APPROVED;
	}
}
