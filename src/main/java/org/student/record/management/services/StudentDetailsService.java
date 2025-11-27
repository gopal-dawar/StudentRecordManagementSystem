package org.student.record.management.services;

import java.util.List;

import org.student.record.management.entity.Student;
import org.student.record.management.entity.StudentDetails;
import org.student.record.management.repository.StudentDetaillsRepository;
import org.student.record.management.repository.StudentRepository;

public class StudentDetailsService {

	public static void addOrUpdateStudentDetails(String email, StudentDetails sd) {
		Student s = StudentRepository.findByEmail(email);
		if (s == null) {
			System.out.println("Wrong email entered");
		} else {
			StudentDetaillsRepository.addOrUpdateStudentDetials(email, sd);
			System.out.println("Student Details Successfully Added");
		}
	}

	public static void viewStudentDetailsByEmail(String email) {
		List<Student> list = StudentDetaillsRepository.viewStudentDetailsByEmail(email);
		if (list != null) {
			list.stream().forEach(System.out::println);
		} else {
			System.out.println("Data not found");
		}
	}

	public static void deleteStudentDetailsByEmail(String email) {
		StudentDetaillsRepository.deleteStudentDetailsByEmail(email);
		System.out.println("Successfully Deleted");
	}

}
