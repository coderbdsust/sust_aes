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

import com.great.cms.entity.CourseRegistration;
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
	private static final Logger log = LoggerFactory
			.getLogger(AdminController.class);

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
		log.debug("initBinder(WebDataBinder binder)");
		System.out.println("ok");
		binder.registerCustomEditor(Role.class, new RoleEditor());
	}

	@RequestMapping({ "/", "/index", "" })
	public String showAdmin(Model model) {
		System.out.println("/admin/index/");
		model.addAttribute("usersCount", userService.countVerifiedUsers());
		model.addAttribute("verificationsNeed",
				userService.countVerificationNeed());
		return "admin/index";

	}

	@RequestMapping(value = "/verification", method = RequestMethod.GET)
	public String userVerification(Model uiModel) {
		//System.out.println("/admin/verification/");
		log.info("/admin/verification/ - Page: admin/verify");
		List<User> userList = userService.getUsers();
		uiModel.addAttribute("userList", userList);
		uiModel.addAttribute("user", new User());
		return "admin/verify_dt";

	}

	@RequestMapping(value = "/verification", method = RequestMethod.POST)
	public String userVerification(User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model uiModel) {
		System.out.println("/admin/verification/");
		User savedUser = userService.getUserById(user.getUserId());
		user.setPassword(savedUser.getPassword());
		user.setRole(user.getRole());
		
		userService.saveOrUpdate(user);

		return "redirect:/admin/verification";

	}

	@RequestMapping(value = "/course/assign", method = RequestMethod.GET)
	public String showCourseAssign(Model uiModel) {
		System.out.println("GET: admin/course/assign");

		uiModel.addAttribute("teaches", new Teaches());
		uiModel.addAttribute("teacherList", teacherService.getTeachers());
		uiModel.addAttribute("courseList", courseService.getCourses());

		return "admin/course_assign";
	}

	@RequestMapping(value = "/course/assign", method = RequestMethod.POST)
	public String assignCourse(Teaches teaches, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model uiModel) {
		System.out.println("POST: admin/course/assign");
		System.out.println("Teaches: " + teaches);
		teachesService.saveOrUpdate(teaches);
		redirectAttributes.addFlashAttribute("message",
				"Course Assign Completed Successfully");
		return "redirect:/admin/course/assign";
	}

	@RequestMapping(value = "/course/view")
	public String adminCourseView(Model uiModel) {
		uiModel.addAttribute("courseList", courseService.getCourses());
		return "admin/course_view";
	}
}
