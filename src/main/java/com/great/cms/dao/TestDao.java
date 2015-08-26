package com.great.cms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.great.cms.entity.Teaches;
import com.great.cms.entity.Test;


public interface TestDao extends GenericDao<Test, Long> {

	List<Test> findByTeachesId(Teaches teachesId);

}
