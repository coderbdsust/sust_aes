package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.TestDao;
import com.great.cms.entity.Teaches;
import com.great.cms.entity.Test;
import com.great.cms.service.TestService;

@Service("TestService")
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao testDao;

	public void saveOrUpdateTest(Test test) {
		if (test.getTestId() == null) {
			testDao.save(test);
		} else {
			testDao.update(test);
		}
	}
	
	public List<Test> getTests(Teaches teachesId) {
		return testDao.findByTeachesId(teachesId);
		
	}
}
