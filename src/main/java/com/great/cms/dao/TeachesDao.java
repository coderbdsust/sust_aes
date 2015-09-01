package com.great.cms.dao;

import java.util.List;

import com.great.cms.entity.Teacher;
import com.great.cms.entity.Teaches;


public interface TeachesDao extends GenericDao<Teaches, Integer> {

	List<Teaches> findByInstructorId(Teacher teacher);

}
