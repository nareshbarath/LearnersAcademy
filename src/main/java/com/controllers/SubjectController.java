package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.SubjectDao;
import com.to.Subject;

@Controller
public class SubjectController {
	@RequestMapping(value = "/subjectmaster", method = RequestMethod.GET)
	public ModelAndView subjectMasterRedirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("subjecthome.jsp");
		mv.addObject("message", "Welcome to Subject master");
		return mv;
	}

	@RequestMapping(value = "/addsubjectform", method = RequestMethod.GET)
	public ModelAndView addSubjectRedirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addsubject.jsp");
		return mv;
	}

	@RequestMapping(value = "/addsubject", method = RequestMethod.POST)
	public ModelAndView subjectAdd(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("name");
		Subject s = new Subject(name);
		SubjectDao sd = new SubjectDao();
		String res = sd.addSubject(s);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}

	@RequestMapping(value = "/viewsubjects", method = RequestMethod.GET)
	public ModelAndView subjectView() {
		ModelAndView mv = new ModelAndView();
		SubjectDao sd = new SubjectDao();
		List<Subject> subjects = sd.getSubjects();
		mv.addObject("message", subjects);
		mv.setViewName("subjectresponse.jsp");
		return mv;
	}

	@RequestMapping(value = "/deletesubject", method = RequestMethod.GET)
	public ModelAndView subjectDelete(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		ModelAndView mv = new ModelAndView();
		SubjectDao sd = new SubjectDao();
		String res = sd.deleteSubject(id);
		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}
}
