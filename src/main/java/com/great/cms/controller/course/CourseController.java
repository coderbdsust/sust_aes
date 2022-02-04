package com.great.cms.controller.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.Course;
import com.great.cms.service.CourseService;
import com.great.cms.service.DepartmentService;

@Controller
@RequestMapping("/course")
public class CourseController {

	private static final Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	CourseService courseService;
	@Autowired
	DepartmentService deptService;

	@RequestMapping("/create")
	public String createCourse(Model model) {
		log.debug("GET: /");
		model.addAttribute("course", new Course());
		model.addAttribute("departments", deptService.getDepartments());
		log.debug("GET: /course/create");
		return "course/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveCourse(Course course, BindingResult bResult, RedirectAttributes redirectAttributes) {
		log.debug("POST: /");
		log.debug("Course: " + course);
		courseService.saveOrUpdate(course);
		redirectAttributes.addFlashAttribute("message", "Course was created successfully");
		log.debug("POST: /course/create");
		return "redirect:/course/create";
	}
}
