package com.great.cms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.Teaches;
import com.great.cms.entity.User;
import com.great.cms.enums.Role;
import com.great.cms.service.CourseService;
import com.great.cms.service.TeacherService;
import com.great.cms.service.TeachesService;
import com.great.cms.service.UserService;
import com.great.cms.utils.editor.RoleEditor;

@Controller
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
public class AdminController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TeachesService teachesService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		log.debug("/");
		binder.registerCustomEditor(Role.class, new RoleEditor());
		log.debug("/initBinder");
	}

	@RequestMapping({ "/", "/index", "" })
	public String showAdmin(Model model) {
		log.debug("GET: /");
		model.addAttribute("usersCount", userService.countVerifiedUsers());
		model.addAttribute("verificationsNeed", userService.countVerificationNeed());
		log.debug("GET: /admin/index");
		return "admin/index";

	}

	@RequestMapping(value = "/verification", method = RequestMethod.GET)
	public String userVerification(Model uiModel) {
		log.debug("GET: /");
		List<User> userList = userService.getUsers();
		uiModel.addAttribute("userList", userList);
		uiModel.addAttribute("user", new User());
		log.debug("GET: /admin/verification/ - Page: admin/verify");
		return "admin/verify_dt";

	}

	@RequestMapping(value = "/verification", method = RequestMethod.POST)
	public String userVerification(User user, BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model uiModel) {
		log.debug("POST: /");
		User savedUser = userService.getUserById(user.getUserId());
		user.setPassword(savedUser.getPassword());
		user.setRole(user.getRole());
		userService.saveOrUpdate(user);
		log.debug("POST: /admin/verification");
		return "redirect:/admin/verification";

	}

	@RequestMapping(value = "/course/assign", method = RequestMethod.GET)
	public String showCourseAssign(Model uiModel) {
		log.debug("GET: /");
		uiModel.addAttribute("teaches", new Teaches());
		uiModel.addAttribute("teacherList", teacherService.getTeachers());
		uiModel.addAttribute("courseList", courseService.getCourses());
		log.debug("GET: /admin/course/assign");
		return "admin/course_assign";
	}

	@RequestMapping(value = "/course/assign", method = RequestMethod.POST)
	public String assignCourse(Teaches teaches, BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model uiModel) {
		log.debug("POST: /");
		log.debug("Teaches: " + teaches);
		teachesService.saveOrUpdate(teaches);
		redirectAttributes.addFlashAttribute("message", "Course Assign Completed Successfully");
		log.debug("POST: /admin/course/assign");
		return "redirect:/admin/course/assign";
	}

	@RequestMapping(value = "/course/view")
	public String adminCourseView(Model uiModel) {
		log.debug("GET: /");
		uiModel.addAttribute("courseList", courseService.getCourses());
		log.debug("GET: /admin/course/view");
		return "admin/course_view";
	}
}
