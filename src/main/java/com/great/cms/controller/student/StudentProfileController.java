package com.great.cms.controller.student;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.great.cms.entity.Student;
import com.great.cms.entity.User;
import com.great.cms.security.utils.UserUtil;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.StudentService;
import com.great.cms.service.UserService;

@Controller
@RequestMapping("/student")
@Secured("ROLE_STUDENT")
public class StudentProfileController {

	private static final Logger log = LoggerFactory.getLogger(StudentProfileController.class);

	@Autowired
	StudentService studentService;
	@Autowired
	CourseRegistrationService courseRegService;
	@Autowired
	UserService userService;
	@Autowired
	DepartmentService deptService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		log.debug("/");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
		log.debug("/initBinder");
	}

	private Student getStudent(String username) {
		log.debug("/");
		User user = userService.getUser(username);
		Student student = studentService.getStudentByUserId(user);
		if (student == null) {
			student = new Student();
		}
		student.setUserId(user);
		return student;
	}

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile(Model uiModel) {
		log.debug("GET: /");
		Student student = UserUtil.getInstance().getStudent();
		if (student.getStudentId() == null) {
			log.debug("GET: /student/profile/edit");
			return "redirect:/student/profile/edit";
		}
		log.debug("student "+student);
		uiModel.addAttribute("student", student);
		log.debug("GET: /student/profile/profile");
		return "student/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editProfile(Model uiModel) {
		log.debug("GET: /");
		Student student = UserUtil.getInstance().getStudent();
		uiModel.addAttribute("departmentList", deptService.getDepartments());
		uiModel.addAttribute("student", student);
		log.debug("GET: /student/profile/edit");
		return "student/edit";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(Student student, BindingResult bandingResult) {
		log.debug("POST: /");
		log.debug("Edit student: " + student);
		studentService.saveOrUpdateStudent(student);
		log.debug("POST: /student/profile/edit");
		return "redirect:/student/profile";
	}

}
