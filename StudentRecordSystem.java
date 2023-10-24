import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double grade;
    private int attendance;

    public Student(String name, int rollNumber, double grade, int attendance) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getGrade() {
        return grade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void updateGrade(double grade) {
        this.grade = grade;
    }

    public void updateAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + ", Attendance: " + attendance;
    }
}

public class StudentRecordSystem {
    private static ArrayList<Student> studentRecords = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Record System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student Grade");
            System.out.println("4. Update Student Attendance");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    updateStudentGrade();
                    break;
                case 4:
                    updateStudentAttendance();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        System.out.print("Enter attendance: ");
        int attendance = scanner.nextInt();

        Student student = new Student(name, rollNumber, grade, attendance);
        studentRecords.add(student);
        System.out.println("Student added successfully!");
    }

    private static void displayStudents() {
        if (studentRecords.isEmpty()) {
            System.out.println("No students in the records.");
        } else {
            System.out.println("Student Records:");
            for (Student student : studentRecords) {
                System.out.println(student);
            }
        }
    }

    private static void updateStudentGrade() {
        System.out.print("Enter student roll number to update grade: ");
        int rollNumber = scanner.nextInt();
        boolean found = false;

        for (Student student : studentRecords) {
            if (student.getRollNumber() == rollNumber) {
                System.out.print("Enter new grade: ");
                double newGrade = scanner.nextDouble();
                student.updateGrade(newGrade);
                found = true;
                System.out.println("Grade updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    private static void updateStudentAttendance() {
        System.out.print("Enter student roll number to update attendance: ");
        int rollNumber = scanner.nextInt();
        boolean found = false;

        for (Student student : studentRecords) {
            if (student.getRollNumber() == rollNumber) {
                System.out.print("Enter new attendance: ");
                int newAttendance = scanner.nextInt();
                student.updateAttendance(newAttendance);
                found = true;
                System.out.println("Attendance updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter student roll number to remove: ");
        int rollNumber = scanner.nextInt();
        boolean removed = false;

        for (Student student : studentRecords) {
            if (student.getRollNumber() == rollNumber) {
                studentRecords.remove(student);
                removed = true;
                System.out.println("Student removed successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }
}


