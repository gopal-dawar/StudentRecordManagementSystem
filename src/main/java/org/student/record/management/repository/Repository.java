package org.student.record.management.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.student.record.management.entity.Student;
import org.student.record.management.utility.DesignPattern;

public class Repository {
	private static SessionFactory factory = DesignPattern.getSessionFactory();

	public static void AddStudent(Student s) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(s);
			transaction.commit();
		} catch (Exception e) {
			System.err.println("Same id already present!");
		}
	}

	public static List<Student> viewStudents() {
		List<Student> list = null;
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			list = session.createQuery("From Student", Student.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Data not found");
		}
		return list;
	}

	public static void updateMarksById(int id, int marks) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Student s = session.find(Student.class, id);
			if (s == null) {
				System.err.println("Student not found");
			}
			s.setMarks(marks);
			session.merge(s);
			transaction.commit();
		}
	}

	public static Boolean deleteById(int id) {
		try (Session session = factory.openSession()) {
			Student s = session.find(Student.class, id);
			if (s == null) {
				return false;
			}
			Transaction transaction = session.beginTransaction();
			session.remove(s);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
