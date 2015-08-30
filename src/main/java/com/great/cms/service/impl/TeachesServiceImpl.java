package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.dao.TeachesDao;
import com.great.cms.entity.Teaches;
import com.great.cms.service.TeachesService;

@Service("TeachesService")
public class TeachesServiceImpl implements TeachesService {

	@Autowired
	TeachesDao teachesDao;

	public void saveOrUpdate(Teaches teaches) {
		if (teaches.getTeachesId() == null) {
			teachesDao.save(teaches);
		} else {
			teachesDao.update(teaches);
		}
	}

	public List<Teaches> getTeachesList() {
		return teachesDao.findAll();
	}

	public Teaches findById(Integer id) {
		return teachesDao.findById(id);
	}

}
