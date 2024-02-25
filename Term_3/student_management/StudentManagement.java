import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static List<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0;

    public static void addStudent(Student student) {
        studentList.add(student);
        totalStudents++;
        System.out.println("Student added successfully.");
    }

    public static void updateStudent(int id, String newName, int newAge, double newGrade) {
        boolean studentFound = false;
        for (Student student : studentList) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setAge(newAge);
                student.setGrade(newGrade);
                System.out.println("Student information updated successfully.");
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Student ID not found.");
        }
    }

    public static void viewStudentDetails(int id) {
        boolean studentFound = false;
        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.println("Student Details:");
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getId());
                System.out.println("Age: " + student.getAge());
                System.out.println("Grade: " + student.getGrade());
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Student ID not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add new student");
            System.out.println("2. Update student information");
            System.out.println("3. View student details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter student age: ");
                    int age;
                    while (true) {
                        try {
                            age = scanner.nextInt();
                            break; // Exit loop if input is valid
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid integer for age.");
                            scanner.nextLine(); // Consume newline
                        }
                    }
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    addStudent(new Student(name, id, age, grade));
                    break;
		case 2:
    System.out.print("Enter student ID to update: ");
    int updateId = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    System.out.print("Enter new age: ");
    int newAge;
    while (true) {
        try {
            newAge = scanner.nextInt();
            break; // Exit loop if input is valid
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer for age.");
            scanner.nextLine(); // Consume newline
        }
    }
    System.out.print("Enter new grade: ");
    double newGrade = scanner.nextDouble();
    updateStudent(updateId, newName, newAge, newGrade);
    break;

                case 3:
                    System.out.print("Enter student ID to view details: ");
                    int viewId = scanner.nextInt();
                    viewStudentDetails(viewId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
        scanner.close();
    }
}
