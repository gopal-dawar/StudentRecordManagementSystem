package org.student.record.management;

import java.util.Scanner;

import org.student.record.management.entity.Student;
import org.student.record.management.entity.StudentDetails;
import org.student.record.management.repository.StudentRepository;
import org.student.record.management.services.StudentDetailsService;
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
//				add student data 
				takedatafromUser();
				break;
			}
			case 2: {
//				view student info but without their personal details
				StudentService.viewAllStudents(1);
				break;
			}
			case 3: {
//				view student info with their personal information 
				StudentService.viewAllStudents(2);
				break;
			}
			case 4: {
//				add or update student details only 
				sc.nextLine();
				System.out.println("Enter the email : ");
				String email = sc.nextLine();
				System.out.println("Enter the student phone number : ");
				String phonenumber = sc.nextLine();

				System.out.println("Enter the address of student : ");
				String address = sc.nextLine();

				System.out.println("Enter the aadharnumber : ");
				String aadharNumber = sc.nextLine();
				StudentDetails sd = new StudentDetails();
				sd.setPhone(phonenumber);
				sd.setAddress(address);
				sd.setAadharNumber(aadharNumber);

				StudentDetailsService.addOrUpdateStudentDetails(email, sd);
				break;
			}
			case 5: {
				sc.nextLine();
				System.out.println("Enter the student email : ");
				String email = sc.nextLine();

				StudentDetailsService.deleteStudentDetailsByEmail(email);

				break;
			}
			case 6: {
				System.out.println("Enter id : ");
				int id = sc.nextInt();

				System.out.println("Enter the marks for udpate : ");
				int marks = sc.nextInt();

				StudentService.updateMarksById(id, marks);
				break;
			}
			case 7: {
				System.out.println("Enter id for delete student : ");
				int id = sc.nextInt();
				StudentRepository.deleteById(id);
				break;
			}
			case 8: {
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
		System.out.println("2. View Student info");
		System.out.println("3. View Student info with their Details");
		System.out.println("4. Add or update student details");
		System.out.println("5. Delete student detials by using email");
		System.out.println("6. Update marks of student by Id");
		System.out.println("7. Delete a student");
		System.out.println("8. close the Application");

	}
}
