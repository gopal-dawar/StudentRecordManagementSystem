package org.student.record.management.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.student.record.management.entity.Student;
import org.student.record.management.entity.StudentDetails;
import org.student.record.management.utility.DesignPattern;

public class Repository {
	private static SessionFactory factory = DesignPattern.getSessionFactory();

	public static Student findByEmail(String email) {
		try (Session session = factory.openSession()) {
			return session.createQuery("from Student where email =:email", Student.class).setParameter("email", email)
					.getSingleResult();
		}
	}

	public static void saveData(Student s, StudentDetails sd) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(sd);
			session.persist(s);
			transaction.commit();
		}
	}

	public static List<Student> viewStudents() {

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			List<Student> list = session.createQuery("From Student", Student.class).getResultList();
			transaction.commit();
			return list;
		}
	}

	public static boolean updateMarks(int id, int marks) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Student s = session.find(Student.class, id);
			s.setMarks(marks);
			session.merge(s);
			transaction.commit();
			return true;
		}
	}

	public static Student findStudentById(int id) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Student s = session.find(Student.class, id);
			transaction.commit();
			return s;
		}
	}

	public static Boolean deleteById(int id) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			int row = session.createMutationQuery("delete from Student where id = :id").setParameter("id", id)
					.executeUpdate();
			transaction.commit();
			return row > 0;
		}
	}

	public static boolean addStudentDetails(Student s, StudentDetails sd) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			sd.setStudent(s);
			s.setStudentDetails(sd);
			session.merge(sd);
			transaction.commit();
			return true;
		}
	}

}
