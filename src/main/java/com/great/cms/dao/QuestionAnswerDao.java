package com.great.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.great.cms.entity.ExamCommittee;
import com.great.cms.entity.QuestionAnswer;


public interface QuestionAnswerDao extends GenericDao<QuestionAnswer, Long> {

}
