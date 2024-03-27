import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeManagement {

    public static void main(String[] args) {
        List<Employee> employees = readDataset("dataset.txt"); // Step 1
        List<String> concatenatedNamesAndDepartments = concatenateNamesAndDepartments(employees); // Step 2
        List<String> filteredConcatenatedNamesAndDepartments = filterByAge(concatenatedNamesAndDepartments, 30); // Step 5
        double averageSalary = calculateAverageSalary(employees); // Step 4

        // Output
        System.out.println("Concatenated Names and Departments:");
        for (String concatenated : concatenatedNamesAndDepartments) {
            System.out.println("\t" + concatenated);
        }
        System.out.println("Filtered Names and Departments (age > 30):");
        System.out.println("\t" + filteredConcatenatedNamesAndDepartments);
        System.out.printf("Average Salary of All Employees: %.1f%n", averageSalary);
    }

    // Step 1: Read the dataset and store it in a collection
    private static List<Employee> readDataset(String filename) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 4) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    String department = data[2];
                    double salary = Double.parseDouble(data[3]);
                    employees.add(new Employee(name, age, department, salary));
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Step 2: Function to concatenate employee names and departments
    private static List<String> concatenateNamesAndDepartments(List<Employee> employees) {
        Function<Employee, String> concatenateFunction = employee -> employee.getName() + " - " + employee.getDepartment();
        return employees.stream().map(concatenateFunction).collect(Collectors.toList());
    }

    // Step 3: Generate a new collection with concatenated strings
    // Step 4: Calculate the average salary of all employees
    private static double calculateAverageSalary(List<Employee> employees) {
        return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }

    // Step 5: Filter employees by age
    private static List<String> filterByAge(List<String> employees, int ageThreshold) {
        return employees.stream()
                        .filter(emp -> {
                            String[] parts = emp.split(" - ");
                            int age;
                            try {
                                age = Integer.parseInt(parts[1].trim()); // Parsing age correctly
                            } catch (NumberFormatException e) {
                                // If parsing fails, consider the employee ineligible (age = 0)
                                age = 0;
                            }
                            return age > ageThreshold;
                        })
                        .collect(Collectors.toList());
    }
}
