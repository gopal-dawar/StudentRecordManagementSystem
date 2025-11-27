package org.student.record.management.services;

import java.util.List;
import java.util.stream.Collectors;

import org.student.record.management.entity.Student;
import org.student.record.management.entity.StudentDetails;
import org.student.record.management.repository.StudentRepository;

public class StudentService {

	public static void AddStudent(Student s, StudentDetails sd) {
		StudentRepository.saveData(s, sd);
		System.out.println("Successfully New Student Added");
	}

	public static void viewAllStudents(int id) {
		if (StudentRepository.viewStudents() != null) {
			System.err.println("Student list");
			List<Student> studentList = StudentRepository.viewStudents();
			if (1 == id) {
				studentList.stream().map(x -> {
					x.setStudentDetails(null);
					return x;
				}).forEach(System.out::println);
			} else {
				studentList.forEach(System.out::println);
			}
		} else {
			System.out.println("Data not Found");
		}
	}

	public static void updateMarksById(int id, int mark) {
		StudentRepository.updateMarks(id, mark);
		System.out.println("Successfully updated");
	}

	public static void deleteById(int id) {
		if (StudentRepository.deleteById(id)) {
			System.out.println("Successfully Deleted");
		} else {
			System.out.println("No Data Matches");
		}
	}
}
