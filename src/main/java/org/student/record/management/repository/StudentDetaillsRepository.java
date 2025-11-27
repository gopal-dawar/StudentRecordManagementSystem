package org.student.record.management.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.student.record.management.entity.Student;
import org.student.record.management.entity.StudentDetails;
import org.student.record.management.utility.DesignPattern;

public class StudentDetaillsRepository {
	private static SessionFactory factory = DesignPattern.getSessionFactory();

	public static void addOrUpdateStudentDetials(String email, StudentDetails sd) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Student s = session.createQuery("from Student where email =:email", Student.class)
					.setParameter("email", email).uniqueResult();
			s.setStudentDetails(sd);
			sd.setStudent(s);
			session.merge(s);
			transaction.commit();
		}
	}

	public static List<Student> viewStudentDetailsByEmail(String email) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			List<Student> list = session.createQuery("from Student where email = :email", Student.class)
					.setParameter("email", email).getResultList();
			transaction.commit();
			return list;
		}
	}

	public static void deleteStudentDetailsByEmail(String email) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();

			Student s = session.createQuery("from Student where email = :email", Student.class)
					.setParameter("email", email).getSingleResult();

			StudentDetails sd = new StudentDetails();
			sd.setAadharNumber(null);
			sd.setAddress(null);
			sd.setPhone(null);

			s.setStudentDetails(sd);
			session.merge(s);
			transaction.commit();
		}
	}
}
