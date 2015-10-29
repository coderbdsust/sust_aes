package com.great.cms.controller.util;

import java.util.Date;

import com.great.cms.enums.ExamStatusType;

public class ExamStatus {
	
	public String getExamStatus(Date startDate, Date endDate, Date currDate) {
		
		if (currDate.after(startDate) && currDate.before(endDate)) {
			return ExamStatusType.Running.name();
		} else if (currDate.before(startDate) && currDate.before(endDate)) {
			return ExamStatusType.Upcoming.name();
		} else {
			return ExamStatusType.Finished.name();
		}
	}

}
