package org.student.record.management.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.student.record.management.entity.Student;
import org.student.record.management.entity.StudentDetails;
import org.student.record.management.repository.Repository;
import org.student.record.management.utility.DesignPattern;

public class StudentDetailsService {
	private static SessionFactory factory = DesignPattern.getSessionFactory();

	public static void addStudentDetails(String email, StudentDetails sd) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Student s = Repository.findByEmail(email);
			if (s == null) {
				System.out.println("Student not found");
			}
			if (Repository.addStudentDetails(s, sd)) {
				System.out.println("Student Details Successfully Added");
			}

			transaction.commit();
		}
	}
}
