package com.great.cms.utils.simulator;

import java.util.List;

import com.great.cms.entity.Question;
import com.great.cms.security.UserUtil;

public class TimeEstimater {

	private static final TimeEstimater ownInstance = new TimeEstimater();

	public static TimeEstimater getInstance() {
		return ownInstance;
	}

	public Long getTotalTime(List<Question> questions) {
		Long time = 0L;
		for (Question q : questions) {
			time += q.getRequiredTime();
		}
		return time;
	}

}
