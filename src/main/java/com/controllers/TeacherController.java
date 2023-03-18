package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.TeacherDao;
import com.to.Teacher;

@Controller
public class TeacherController {
	@RequestMapping(value = "/teachermaster", method = RequestMethod.GET)
	public ModelAndView teacherMasterRedirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("teacherhome.jsp");
		mv.addObject("message", "Welcome to Teacher master");
		return mv;
	}

	@RequestMapping(value = "/addteacherform", method = RequestMethod.GET)
	public ModelAndView addTeacherRedirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addteacher.jsp");
		return mv;
	}

	@RequestMapping(value = "/addteacher", method = RequestMethod.POST)
	public ModelAndView teacherAdd(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Teacher t = new Teacher(name, email);
		TeacherDao td = new TeacherDao();
		String res = td.addTeacher(t);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}

	@RequestMapping(value = "/viewteachers", method = RequestMethod.GET)
	public ModelAndView teacherView() {
		ModelAndView mv = new ModelAndView();
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getTeachers();
		mv.addObject("message", teachers);
		mv.setViewName("teacherresponse.jsp");
		return mv;
	}

	@RequestMapping(value = "/deleteteacher", method = RequestMethod.GET)
	public ModelAndView teacherDelete(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		ModelAndView mv = new ModelAndView();
		TeacherDao td = new TeacherDao();
		String res = td.deleteTeacher(id);
		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}
}
