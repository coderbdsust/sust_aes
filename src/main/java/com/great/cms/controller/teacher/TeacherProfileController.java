package com.great.cms.controller.teacher;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.Teacher;
import com.great.cms.entity.User;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.DesignationService;
import com.great.cms.service.TeacherService;
import com.great.cms.service.UserService;

@Controller
@RequestMapping("/teacher")
@Secured("ROLE_TEACHER")
public class TeacherProfileController {

	private static final Logger log = LoggerFactory.getLogger(TeacherProfileController.class);

	@Autowired
	TeacherService teacherService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DesignationService designationService;
	@Autowired
	UserService userService;

	private Teacher getTeacher(String username) {
		log.debug("/");
		User user = userService.getUser(username);
		log.debug("User " + user);
		Teacher teacher = teacherService.getTeacherByUserId(user);
		log.debug("Teacher " + teacher);
		if (teacher == null) {
			teacher = new Teacher();
		}
		teacher.setUserId(user);
		return teacher;
	}

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile(Principal principal, Model uiModel) {
		log.debug("GET: /");
		Teacher teacher = getTeacher(principal.getName());
		if (teacher.getInstructorId() == null) {
			log.debug("GET: /teacher/profile");
			return "redirect:/teacher/profile/edit";
		}
		uiModel.addAttribute("teacher", teacher);
		log.debug("GET: /teacher/profile");
		return "teacher/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editProfile(Principal principal, Model uiModel) {
		log.debug("GET: /");
		uiModel.addAttribute("designationList", designationService.getDesignations());
		uiModel.addAttribute("departmentList", departmentService.getDepartments());
		Teacher teacher = getTeacher(principal.getName());
		log.debug("Init: " + teacher);
		uiModel.addAttribute("teacher", teacher);
		log.debug("GET: /teacher/profile/edit");
		return "teacher/edit";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(Teacher teacher, BindingResult bandingResult, RedirectAttributes redirectAttributes) {
		log.debug("POST: /");
		log.debug("Edit teacher: " + teacher);
		teacherService.saveOrUpdateTeacher(teacher);
		redirectAttributes.addFlashAttribute("message", "- Updated Successfully");
		log.debug("POST: /teacher/profile/edit");
		return "redirect:/teacher/profile";
	}

}
