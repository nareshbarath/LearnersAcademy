package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.Lesson;
import com.util.HibernateUtil;

public class LessonDao {

	public String addLesson(Lesson l) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(l);
			transaction.commit();
			return "Assignment successful";
		} catch (Exception e) {
			transaction.rollback();
			return "Error Assigning";
		}
	}

	public List<Lesson> getLessons() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Lesson a", Lesson.class).getResultList();
		}
	}

	public String deleteLesson(long id) {
		Transaction transaction = null;
		Lesson l = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			l = session.get(Lesson.class, id);
			session.delete(l);
			transaction.commit();
			return "Deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting";
		}
	}
}
