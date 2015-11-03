package com.great.cms.controller.utils;

import java.util.Date;

import com.great.cms.enums.ExamStatusType;

public class ExamStatus {
	
	public ExamStatusType getExamStatus(Date startDate, Date endDate, Date currDate) {
		
		if (currDate.after(startDate) && currDate.before(endDate)) {
			return ExamStatusType.Running;
		} else if (currDate.before(startDate) && currDate.before(endDate)) {
			return ExamStatusType.Upcoming;
		} else {
			return ExamStatusType.Finished;
		}
	}

}
