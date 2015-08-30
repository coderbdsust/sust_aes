package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.Teaches;
import com.great.cms.entity.Test;

public interface TestService {
	public void saveOrUpdateTest(Test test);

	public List<Test> getTests(Teaches teachesId);
}
