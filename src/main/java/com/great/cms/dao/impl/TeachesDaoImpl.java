package com.great.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.dao.TeachesDao;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.Teaches;

@Repository
public class TeachesDaoImpl extends GenericDaoImpl<Teaches, Integer> implements
		TeachesDao {

	public TeachesDaoImpl() {
		super(Teaches.class);
	}
	
	@Override
	public List<Teaches> findByInstructorId(Teacher teacher) {
		Query query = this.em.createQuery("SELECT t FROM Teaches t WHERE t.instructorId=:instructorId");
		query.setParameter("instructorId", teacher);
		List<Teaches> teachesList = query.getResultList();
		return teachesList;
	}
	
}
