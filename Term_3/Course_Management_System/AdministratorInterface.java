import java.util.Scanner;

public class AdministratorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Administrator Interface:");
            System.out.println("1. Add Course");
            System.out.println("2. Enroll Student");
            System.out.println("3. Assign Grade");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Loop until valid input is provided
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Implement code to add a course
                    break;
                case 2:
                    // Implement code to enroll a student
                    break;
                case 3:
                    // Implement code to assign a grade
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
}
