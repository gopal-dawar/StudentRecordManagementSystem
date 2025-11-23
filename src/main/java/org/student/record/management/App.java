package org.student.record.management;

import java.util.Scanner;

import org.student.record.management.entity.Student;
import org.student.record.management.repository.Repository;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.err.println("=========================================");
		System.out.println("Welcome on the Student Record Management!");
		System.err.println("=========================================");
		int choice = 0;
		do {
			System.err.println("Select option...!");
			System.out.println("1. Add Student");
			System.out.println("2. View All Student");
			System.out.println("3. Update marks of student by Id");
			System.out.println("4. Delete a student");
			System.out.println("5. close the Application");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.err.println("Provide the following information!");
				System.out.println("Enter the id : ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name : ");
				String name = sc.nextLine();
				System.out.println("Enter email : ");
				String email = sc.nextLine();

				System.out.println("Enter course : ");
				String course = sc.nextLine();

				System.out.println("Enter the marks : ");
				int marks = sc.nextInt();

				Student s = new Student();
				s.setId(id);
				s.setName(name);
				s.setEmail(email);
				s.setCourse(course);
				s.setMarks(marks);
				Repository.AddStudent(s);
				System.err.println("Successfully Added!");
				break;
			}
			case 2: {
				System.err.println("Student list");
				Repository.viewStudents().stream().forEach(System.out::println);
				break;
			}
			case 3: {
				System.out.println("Enter id : ");
				int id = sc.nextInt();

				System.out.println("Enter the marks for udpate : ");
				int marks = sc.nextInt();

				Repository.updateMarksById(id, marks);
				System.out.println("Successfully Updated");
				break;
			}
			case 4: {
				System.out.println("Enter id for delete student : ");
				int id = sc.nextInt();
				Repository.deleteById(id);

				System.out.println("Successfully Removed..!");
				break;
			}
			case 5: {
				System.err.println("Are you sure!");
				sc.nextLine();
				String yes = sc.nextLine();

				if (yes.equalsIgnoreCase("yes")) {
					choice++;
					System.err.println("Application closed...");
				} else {
					choice = -1;
				}
				break;
			}
			default:
				System.err.println("Wrong input");
			}

		} while (choice != 6);
		sc.close();
	}
}
