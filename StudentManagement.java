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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

public class StudentManagement {
    private ArrayList<Student> studentList;

    public StudentManagement() {
        studentList = new ArrayList<>();
    }

    public void addStudents(int count) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            System.out.print("Enter student's first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter student's last name: ");
            String lastName = scanner.nextLine();
            Student student = new Student(firstName, lastName);
            studentList.add(student);
        }
        System.out.println("Student list added successfully.\n");
    }

    public void findStudentsByLastName(String lastName) {
        System.out.println("Students with last name \"" + lastName + "\":");
        boolean found = false;
        for (Student student : studentList) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student.getFullName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with last name \"" + lastName + "\".\n");
        } else {
            System.out.println();
        }
    }

    public void findAndEditStudentByFullName(String fullName) {
        boolean found = false;
        for (Student student : studentList) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new first name for " + fullName + ": ");
                String newFirstName = scanner.nextLine();
                student.setFirstName(newFirstName);

                System.out.print("Enter new last name for " + fullName + ": ");
                String newLastName = scanner.nextLine();
                student.setLastName(newLastName);

                System.out.println("Name updated successfully.\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with full name \"" + fullName + "\" not found.\n");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        int option = 0;
        do {
            System.out.println("Student Management System");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter the number of students: ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character
                    management.addStudents(count);
                    break;
                case 2:
                    System.out.print("Enter last name to search: ");
                    String searchLastName = scanner.nextLine();
                    management.findStudentsByLastName(searchLastName);
                    break;
                case 3:
                    System.out.print("Enter full name to search: ");
                    String searchFullName = scanner.nextLine();
                    management.findAndEditStudentByFullName(searchFullName);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        } while (option != 0);
    }
}