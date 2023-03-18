package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.*;
import com.util.HibernateUtil;

public class TeacherDao {

	public String addTeacher(Teacher t) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			return "Teacher added successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error adding teacher";
		}
	}

	public List<Teacher> getTeachers() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Teacher a", Teacher.class).getResultList();
		}
	}

	public String deleteTeacher(long id) {
		Transaction transaction = null;
		Teacher teacher = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			teacher = session.get(Teacher.class, id);
			session.delete(teacher);
			transaction.commit();
			return "Teacher deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting teacher";
		}
	}

	public Teacher getteacherbyID(long id) {
		Teacher t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.get(Teacher.class, id);
			return t;
		}
	}
}
