package com.great.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.Teacher;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.DesignationService;
import com.great.cms.service.TeacherService;

@Controller
@RequestMapping("/teacher")
@Secured("ROLE_TEACHER")
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DesignationService designationService;

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile() {
		System.out.println("/teacher/profile");
		return "teacher/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editProfile(Model uiModel) {
		System.out.println("teacher/profile/edit");
		uiModel.addAttribute("designationList",
				designationService.getDesignations());
		uiModel.addAttribute("departmentList",
				departmentService.getDepartments());

		return "teacher/edit";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(Teacher teacher, BindingResult bandingResult) {
		System.out.println("teacher/profile/edit");
		System.out.println("Edit teacher: " + teacher);
		return "redirect:/teacher/profile";
	}
}
