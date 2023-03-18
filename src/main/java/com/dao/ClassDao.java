package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.Classes;
import com.util.HibernateUtil;

public class ClassDao {
	public String addClass(Classes c) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(c);
			transaction.commit();
			return "Class added successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error adding Class";
		}
	}

	public List<Classes> getClasss() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Classes a", Classes.class).getResultList();
		}
	}

	public String deleteClass(long id) {
		Transaction transaction = null;
		Classes c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			c = session.get(Classes.class, id);
			session.delete(c);
			transaction.commit();
			return "Class deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting class";
		}
	}

	public Classes getclassByID(long id) {
		Classes c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			c = session.get(Classes.class, id);
			return c;
		}
	}
}
