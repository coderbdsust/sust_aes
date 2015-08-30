package com.great.cms.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.great.cms.entity.Teaches;

public interface TeachesService {
	public void saveOrUpdate(Teaches teaches) ;

	public List<Teaches> getTeachesList();

	public Teaches findById(Integer id);
}
