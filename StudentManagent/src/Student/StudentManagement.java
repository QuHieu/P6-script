package Student;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

public class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Student Management System");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudentsByFullName();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }

    private static void enterStudentList() {
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter first name of student " + (i + 1) + ": ");
            String firstName = scanner.next();
            System.out.print("Enter last name of student " + (i + 1) + ": ");
            String lastName = scanner.next();

            Student student = new Student(firstName, lastName);
            studentList.add(student);
        }

        System.out.println("Student list entered successfully.");
    }

    private static void findStudentsByLastName() {
        System.out.print("Enter the last name to search for: ");
        String searchLastName = scanner.next();

        for (Student student : studentList) {
            if (student.getFullName().contains(searchLastName)) {
                System.out.println("Student found: " + student.getFullName());
            }
        }
    }

    private static void findAndEditStudentsByFullName() {
        System.out.print("Enter the full name of the student to edit: ");
        String searchFullName = scanner.nextLine(); // Consume the newline character left in the buffer
        searchFullName = scanner.nextLine();

        for (Student student : studentList) {
            if (student.getFullName().equals(searchFullName)) {
                System.out.println("Student found: " + student.getFullName());
                System.out.print("Enter the new first name: ");
                String newFirstName = scanner.next();
                System.out.print("Enter the new last name: ");
                String newLastName = scanner.next();

                student = new Student(newFirstName, newLastName);
                System.out.println("Student information updated successfully.");
                return; // Exit the method after editing the first matching student
            }
        }

        System.out.println("Student not found with the given full name.");
    }
}
