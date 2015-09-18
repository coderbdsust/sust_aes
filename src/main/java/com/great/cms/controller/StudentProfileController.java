package com.great.cms.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.great.cms.entity.CourseRegistration;
import com.great.cms.entity.Student;
import com.great.cms.entity.User;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.CourseService;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.StudentService;
import com.great.cms.service.UserService;

@Controller
@RequestMapping("/student")
@Secured("ROLE_STUDENT")
public class StudentProfileController {

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
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
	}

	private Student getStudent(String username) {
		User user = userService.getUser(username);
		Student student = studentService.getStudentByUserId(user);
		if (student == null) {
			student = new Student();
		}
		student.setUserId(user);
		return student;
	}

	@RequestMapping({ "/profile", "/", "" })
	public String showProfile(Principal principal, Model uiModel) {
		Student student = getStudent(principal.getName());
		if (student.getStudentId() == null) {
			return "redirect:/student/profile/edit";
		}
		System.out.println(student);
		uiModel.addAttribute("student", student);
		System.out.println("/student/profile");
		return "student/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editProfile(Principal principal, Model uiModel) {
		System.out.println("student/profile/edit");
		Student student = getStudent(principal.getName());
		uiModel.addAttribute("departmentList", deptService.getDepartments());
		uiModel.addAttribute("student", student);
		return "student/edit";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(Student student, BindingResult bandingResult) {
		System.out.println("student/profile/edit");
		System.out.println("Edit Student: " + student);
		studentService.saveOrUpdateStudent(student);
		return "redirect:/student/profile";
	}

//	@RequestMapping(value = "/profile/show", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Student> showProfileInfo() {
//		System.out.println("/profile/show");
//		List<Student> students = studentService.getStudents();
//		System.out.println("/profile/show : data found!");
//		return students;
//	}

}
