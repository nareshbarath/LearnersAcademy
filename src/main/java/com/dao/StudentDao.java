package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.Student;
import com.util.HibernateUtil;

public class StudentDao {
	public String addStudent(Student s) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(s);
			transaction.commit();
			return "Student added successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error adding Student";
		}
	}

	public List<Student> getStudent() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Student a", Student.class).getResultList();
		}
	}

	public String deleteStudent(long id) {
		Transaction transaction = null;
		Student s = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			s = session.get(Student.class, id);
			session.delete(s);
			transaction.commit();
			return "Student deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting Student";
		}
	}
}
