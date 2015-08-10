package com.great.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.great.cms.entity.Exam;
import com.great.cms.entity.ExamCommittee;


public interface ExamDao extends GenericDao<Exam, Long> {

}
