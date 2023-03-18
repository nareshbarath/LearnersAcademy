package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ClassDao;
import com.to.Classes;

@Controller
public class ClassController {
	
	@RequestMapping(value = "/classmaster", method = RequestMethod.GET)
	public ModelAndView classMasterRedirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("classhome.jsp");
		mv.addObject("message", "Welcome to Class master");
		return mv;
	}

	@RequestMapping(value = "/addclassform", method = RequestMethod.GET)
	public ModelAndView addClassRedirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addclass.jsp");
		return mv;
	}

	@RequestMapping(value = "/addclass", method = RequestMethod.POST)
	public ModelAndView classAdd(HttpServletRequest request, HttpServletResponse response) {

		String section = request.getParameter("section");
		String std = request.getParameter("std");
		Classes c = new Classes(std, section);
		ClassDao cd = new ClassDao();
		String res = cd.addClass(c);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}

	@RequestMapping(value = "/viewclasses", method = RequestMethod.GET)
	public ModelAndView classView() {
		ModelAndView mv = new ModelAndView();
		ClassDao cd = new ClassDao();
		List<Classes> c = cd.getClasss();
		mv.addObject("message", c);
		mv.setViewName("classresponse.jsp");
		return mv;
	}

	@RequestMapping(value = "/deleteclass", method = RequestMethod.GET)
	public ModelAndView classDelete(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		ModelAndView mv = new ModelAndView();
		ClassDao cd = new ClassDao();
		String res = cd.deleteClass(id);
		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}
}
