package org.student.record.management;

import java.util.Scanner;

import org.student.record.management.entity.Student;
import org.student.record.management.entity.StudentDetails;
import org.student.record.management.repository.Repository;
import org.student.record.management.services.StudentService;

/**
 * Hello world!
 */
public class App {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.err.println("=========================================");
		System.out.println("Welcome on the Student Record Management!");
		System.err.println("=========================================");

		boolean b = false;
		while (!b) {
			menu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				takedatafromUser();
				break;
			}
			case 2: {
				StudentService.viewAllStudents(1);
				break;
			}
			case 3: {
				StudentService.viewAllStudents(2);
				break;
			}
			case 4: {
				System.out.println("Enter id : ");
				int id = sc.nextInt();

				System.out.println("Enter the marks for udpate : ");
				int marks = sc.nextInt();

				StudentService.updateMarksById(id, marks);
				break;
			}
			case 5: {
				System.out.println("Enter id for delete student : ");
				int id = sc.nextInt();
				Repository.deleteById(id);
				break;
			}
			case 6: {
				System.err.println("Are you sure!");
				sc.nextLine();
				String yes = sc.nextLine();

				if (yes.equalsIgnoreCase("yes")) {
					b = true;
					System.err.println("Application closed...");
				}
				break;
			}
			default:
				System.err.println("Wrong input");
			}
		}
		sc.close();

	}

	public static void takedatafromUser() {

		System.err.println("Provide the following information!");
		sc.nextLine();
		System.out.println("Enter name : ");
		String name = sc.nextLine();

		System.out.println("Enter email : ");
		String email = sc.nextLine();

		System.out.println("Enter course : ");
		String course = sc.nextLine();

		System.out.println("Enter the marks : ");
		int marks = sc.nextInt();

		System.out.println("Now Enter the Student Details..");
		sc.nextLine();
		System.out.println("Enter phone : ");
		String phone = sc.nextLine();

		System.out.println("Enter the address : ");
		String address = sc.nextLine();

		System.out.println("Enter AddarhNumber : ");
		String aadharNumber = sc.nextLine();

		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		s.setCourse(course);
		s.setMarks(marks);

		StudentDetails sd = new StudentDetails();
		sd.setPhone(phone);
		sd.setAddress(address);
		sd.setAadharNumber(aadharNumber);
		s.setStudentDetails(sd);

		StudentService.AddStudent(s, sd);
	}

	public static void menu() {
		System.out.println("Select option...!");
		System.out.println("1. Add Student");
		System.out.println("2. View All Student");
		System.out.println("3. View All Student with Details");
		System.out.println("4. Update marks of student by Id");
		System.out.println("5. Delete a student");
		System.out.println("6. close the Application");

	}
}
