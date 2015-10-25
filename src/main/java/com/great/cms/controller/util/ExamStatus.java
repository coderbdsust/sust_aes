package com.great.cms.controller.util;

import java.util.Date;

public class ExamStatus {
	
	public String getExamStatus(Date startDate, Date endDate, Date currDate) {
		
		if (currDate.after(startDate) && currDate.before(endDate)) {
			return "Running";
		} else if (currDate.before(startDate) && currDate.before(endDate)) {
			return "Upcoming";
		} else {
			return "Finished";
		}
	}

}
