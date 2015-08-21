package com.great.cms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.Student;
import com.great.cms.entity.Teacher;
import com.great.cms.entity.User;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.DesignationService;
import com.great.cms.service.TeacherService;
import com.great.cms.service.UserService;

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
	@Autowired
	UserService userService;

	private Teacher getTeacher(String teacherName) {
		User user = userService.getUser(teacherName);
		Teacher teacher = teacherService.getTeacher(user.getUserId());
		if (teacher == null) {
			
			teacher = new Teacher();
		}
		teacher.setUserId(user);
		return teacher;
	}

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile(Principal principal, Model uiModel) {

		Teacher teacher = getTeacher(principal.getName());
		if (teacher.getInstructorId() == null) {
			return "redirect:/teacher/profile/edit";
		}
		System.out.println("/teacher/profile");
		uiModel.addAttribute("teacher", teacher);
		return "teacher/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editProfile(Principal principal, Model uiModel) {
		System.out.println("teacher/profile/edit");
		uiModel.addAttribute("designationList",
				designationService.getDesignations());
		uiModel.addAttribute("departmentList",
				departmentService.getDepartments());
		Teacher teacher = getTeacher(principal.getName());
		uiModel.addAttribute("teacher", teacher);
		return "teacher/edit";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(Teacher teacher, BindingResult bandingResult) {
		System.out.println("teacher/profile/edit");
		System.out.println("Edit teacher: " + teacher);
		return "redirect:/teacher/profile";
	}
}
