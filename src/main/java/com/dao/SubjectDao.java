package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.Subject;
import com.to.Teacher;
import com.util.HibernateUtil;

public class SubjectDao {
	public String addSubject(Subject s) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(s);
			transaction.commit();
			return "Subject added successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error adding Subject";
		}
	}

	public List<Subject> getSubjects() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Subject a", Subject.class).getResultList();
		}
	}

	public String deleteSubject(long id) {
		Transaction transaction = null;
		Subject subject = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			subject = session.get(Subject.class, id);
			session.delete(subject);
			transaction.commit();
			return "Subject deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting subject";
		}
	}

	public Subject getsubjectbyID(long id) {
		Subject s = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			s = session.get(Subject.class, id);
			return s;
		}
	}
}
