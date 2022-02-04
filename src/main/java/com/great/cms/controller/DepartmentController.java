package com.great.cms.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.service.DepartmentService;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
	
	static final Logger log = LoggerFactory
			.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService deptService;

	@RequestMapping("/search")
	public String searchDepartment(Model model) {
		log.debug("GET: /");
		model.addAttribute("depts", deptService.getDepartments());
		log.debug("GET: /dept/search");
		return "dept/create";
	}

	@RequestMapping("/result/{surname}")
	public String searchResult(@PathVariable("surname") String surname,
			Principal principal, Model model) {
		log.debug("GET: /");
		log.debug(principal.getName());
		log.debug("/result/" + surname);
		model.addAttribute("depts", deptService.getDepartments());
		log.debug("GET: /dept/result/"+surname);
		return "dept/results :: resultsList";
	}

}
