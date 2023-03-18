package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ClassDao;
import com.dao.StudentDao;
import com.to.Classes;
import com.to.Student;

@Controller
public class StudentController {
	@RequestMapping(value = "/studentmaster", method = RequestMethod.GET)
	public ModelAndView studentMasterRedirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studenthome.jsp");
		mv.addObject("message", "Welcome to Student master");
		return mv;
	}

	@RequestMapping(value = "/addstudentform", method = RequestMethod.GET)
	public ModelAndView addStudentRedirect() {
		ModelAndView mv = new ModelAndView();
		ClassDao cd = new ClassDao();
		List<Classes> c = cd.getClasss();
		mv.addObject("message", c);
		mv.setViewName("addstudent.jsp");
		return mv;
	}

	@RequestMapping(value = "/addstudent", method = RequestMethod.POST)
	public ModelAndView studentAdd(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		StudentDao sd = new StudentDao();
		String name = request.getParameter("name");
		long classid = Long.parseLong(request.getParameter("classid"));
		ClassDao cd = new ClassDao();
		Classes c = cd.getclassByID(classid);

		if (c == null) {
			mv.addObject("message", "Please enter the correct IDs");
			mv.setViewName("response.jsp");
			return mv;
		}

		Student s = new Student(name, c);
		String res = sd.addStudent(s);

		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}

	@RequestMapping(value = "/viewstudents", method = RequestMethod.GET)
	public ModelAndView studentView() {
		ModelAndView mv = new ModelAndView();
		StudentDao sd = new StudentDao();
		List<Student> s = sd.getStudent();
		mv.addObject("message", s);
		mv.setViewName("studentresponse.jsp");
		return mv;
	}

	@RequestMapping(value = "/deletestudent", method = RequestMethod.GET)
	public ModelAndView studentDelete(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		ModelAndView mv = new ModelAndView();
		StudentDao sd = new StudentDao();
		String res = sd.deleteStudent(id);
		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}
}
