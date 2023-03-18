package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ClassDao;
import com.dao.LessonDao;
import com.dao.SubjectDao;
import com.dao.TeacherDao;
import com.to.Classes;
import com.to.Lesson;
import com.to.Subject;
import com.to.Teacher;

@Controller
public class LessonController {

	@RequestMapping(value = "/assignmaster", method = RequestMethod.GET)
	public ModelAndView lessonMasterRedirect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("lessonhome.jsp");
		mv.addObject("message", "Welcome to Assignment master");
		return mv;
	}

	@RequestMapping(value = "/addlessonform", method = RequestMethod.GET)
	public ModelAndView addLessonRedirect() {
		ModelAndView mv = new ModelAndView();
		ClassDao cd = new ClassDao();
		List<Classes> c = cd.getClasss();
		TeacherDao td = new TeacherDao();
		List<Teacher> t = td.getTeachers();
		SubjectDao sd = new SubjectDao();
		List<Subject> s = sd.getSubjects();
		mv.addObject("class", c);
		mv.addObject("teacher", t);
		mv.addObject("subject", s);
		mv.setViewName("addlesson.jsp");
		return mv;
	}

	@RequestMapping(value = "/addlesson", method = RequestMethod.POST)
	public ModelAndView lessonAdd(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		LessonDao ld = new LessonDao();
		long classid = Long.parseLong(request.getParameter("classid"));
		ClassDao cd = new ClassDao();
		Classes c = cd.getclassByID(classid);
		long teacherid = Long.parseLong(request.getParameter("teacherid"));
		TeacherDao td = new TeacherDao();
		Teacher t = td.getteacherbyID(teacherid);
		long subjectid = Long.parseLong(request.getParameter("subjectid"));
		SubjectDao sd = new SubjectDao();
		Subject s = sd.getsubjectbyID(subjectid);

		if (c == null || t == null || s == null) {
			mv.addObject("message", "Please enter the correct IDs");
			mv.setViewName("response.jsp");
			return mv;
		}

		Lesson l = new Lesson(c, s, t);
		String res = ld.addLesson(l);

		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}

	@RequestMapping(value = "/viewlessons", method = RequestMethod.GET)
	public ModelAndView lessonView() {
		ModelAndView mv = new ModelAndView();
		LessonDao ld = new LessonDao();
		List<Lesson> l = ld.getLessons();
		mv.addObject("message", l);
		mv.setViewName("lessonresponse.jsp");
		return mv;
	}

	@RequestMapping(value = "/deletelesson", method = RequestMethod.GET)
	public ModelAndView lessonDelete(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		ModelAndView mv = new ModelAndView();
		LessonDao ld = new LessonDao();
		String res = ld.deleteLesson(id);
		mv.setViewName("response.jsp");
		mv.addObject("message", res);
		return mv;
	}
}
