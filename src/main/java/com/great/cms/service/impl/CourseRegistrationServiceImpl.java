package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.CourseRegistrationDao;
import com.great.cms.entity.CourseRegistration;
import com.great.cms.service.CourseRegistrationService;

@Service("CourseRegistrationService")
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

	@Autowired CourseRegistrationDao courseRegDao;
	
	@Override
	public void saveOrUpdate(CourseRegistration courseRegistration) {
		if(courseRegistration.getCourseRegId()==null){
			courseRegDao.save(courseRegistration);
		}else{
			courseRegDao.update(courseRegistration);
		}
	}
	
	public List<CourseRegistration> getCourseRegistrations(){
		return courseRegDao.findAll();
	}
	
}
