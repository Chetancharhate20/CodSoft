package internship;
import java.util.ArrayList;
import java.util.Scanner;

//  we created here a Student class representing individual students
class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

// Creating a class to manage the collection of students
class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

//  We are creating  a UserInterface class to interact with the Student Management System
public class StudentManagementSystemUI {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int option = getOptionFromUser();

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    studentManagementSystem.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nStudent Management System Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
    }

    private static int getOptionFromUser() {
        System.out.print("Choose an option (1-5): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid option.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter student roll number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll number must be an integer.");
            System.out.print("Enter student roll number: ");
            scanner.next(); // Consume invalid input
        }
        int rollNumber = scanner.nextInt();

        System.out.print("Enter student grade: ");
        String grade = scanner.next();

        Student newStudent = new Student(name, rollNumber, grade);
        studentManagementSystem.addStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter roll number of the student to remove: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll number must be an integer.");
            System.out.print("Enter roll number of the student to remove: ");
            scanner.next(); // Consume invalid input
        }
        int rollNumber = scanner.nextInt();

        studentManagementSystem.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }

    private static void searchStudent() {
        System.out.print("Enter roll number of the student to search: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll number must be an integer.");
            System.out.print("Enter roll number of the student to search: ");
            scanner.next(); // Consume invalid input
        }
        int rollNumber = scanner.nextInt();

        Student foundStudent = studentManagementSystem.searchStudent(rollNumber);
        if (foundStudent != null) {
            System.out.println("Student found:\n" + foundStudent);
        } else {
            System.out.println("Student not found.");
        }
    }
}
