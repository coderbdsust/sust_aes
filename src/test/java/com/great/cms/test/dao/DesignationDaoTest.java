package com.great.cms.test.dao;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.dao.DesignationDao;
import com.great.cms.entity.Designation;

@ContextConfiguration("file:src/main/webapp/WEB-INF/sustaes-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class DesignationDaoTest {
	
	@Autowired DesignationDao designDao;
	
	@Test
	public void saveDesignation(){
		ArrayList<Designation> designations = new ArrayList<>();
		designations.add(new Designation("Professor"));
		designations.add(new Designation("Associate Professor"));
		designations.add(new Designation("Assistant Professor"));
		designations.add(new Designation("Lecturer"));
		
		for(Designation d:designations){
			designDao.save(d);
		}
		
		List<Designation> designs = designDao.findAll();
		assertEquals(4,designs.size());
		for(Designation d:designs){
			System.out.println(d.getDesigId()+" "+d.getDesigName());
		}
	}

}
