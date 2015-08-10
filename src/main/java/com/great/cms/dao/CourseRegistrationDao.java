package com.great.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.great.cms.entity.Course;
import com.great.cms.entity.CourseRegistration;


public interface CourseRegistrationDao extends GenericDao<CourseRegistration, Integer>{

}
