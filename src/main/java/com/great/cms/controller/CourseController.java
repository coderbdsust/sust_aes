package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.Course;

@Controller
@RequestMapping("/course")
public class CourseController {

	@RequestMapping("/create")
	public String createCourse(Model model) {
		System.out.println("course/create");
		model.addAttribute("course", new Course());
		return "course/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveCourse(Course course, BindingResult bResult) {
		System.out.println("course/create");
		System.out.println("Course: " + course);
		return "course/create";
	}
}
