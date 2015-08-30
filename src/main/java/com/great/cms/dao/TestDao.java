package com.great.cms.dao;

import java.util.List;

import com.great.cms.entity.Teaches;
import com.great.cms.entity.Test;


public interface TestDao extends GenericDao<Test, Long> {

	List<Test> findByTeachesId(Teaches teachesId);

}
