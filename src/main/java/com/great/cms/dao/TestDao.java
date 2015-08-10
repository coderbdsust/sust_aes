package com.great.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.great.cms.entity.Test;


public interface TestDao extends GenericDao<Test, Long> {

}
