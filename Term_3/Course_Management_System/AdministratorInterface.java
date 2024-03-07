import java.util.Scanner;

public class AdministratorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    enrollStudent(scanner);
                    break;
                case 3:
                    assignGrade(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("Administrator Interface:");
        System.out.println("1. Add Course");
        System.out.println("2. Enroll Student");
        System.out.println("3. Assign Grade");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    public static void addCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter maximum capacity: ");
        int maxCapacity = scanner.nextInt();
        CourseManagement.addCourse(courseCode, courseName, maxCapacity);
    }

    public static void enrollStudent(Scanner scanner) {
        scanner.nextLine(); // Consume newline character left by previous nextInt() call

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        int studentID;
        while (true) {
            System.out.print("Enter student ID: ");
            if (scanner.hasNextInt()) {
                studentID = scanner.nextInt();
                scanner.nextLine(); // Consume newline character left by nextInt()
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid student ID (numeric value).");
                scanner.nextLine(); // Consume invalid input
            }
        }

        System.out.print("Enter course code to enroll: ");
        String courseCode = scanner.next();
        CourseManagement.enrollStudent(new Student(studentName, studentID), new Course(courseCode, "", 0));
    }

    public static void assignGrade(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        System.out.print("Enter grade: ");
        String grade = scanner.next();
        CourseManagement.assignGrade(new Student("", studentID), new Course(courseCode, "", 0), grade);
    }
}
