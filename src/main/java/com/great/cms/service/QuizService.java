package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.Quiz;
import com.great.cms.entity.Teaches;

public interface QuizService {
	public void saveOrUpdateTest(Quiz quiz);

	public List<Quiz> getQuizes(Teaches teachesId);
}
