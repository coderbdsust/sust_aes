package com.great.cms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.service.DepartmentService;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	DepartmentService deptService;

	@RequestMapping("/search")
	public String searchDepartment(Model model) {
		model.addAttribute("depts", deptService.getDepartments());
		return "dept/create";
	}

	@RequestMapping("/result/{surname}")
	public String searchResult(@PathVariable("surname") String surname,
			Principal principal, Model model) {
		System.out.println(principal.getName());
		System.out.println("/result/" + surname);
		model.addAttribute("depts", deptService.getDepartments());
		return "dept/results :: resultsList";
	}

}
