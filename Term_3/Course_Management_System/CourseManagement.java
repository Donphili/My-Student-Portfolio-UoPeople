import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();

    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course newCourse = new Course(courseCode, name, maxCapacity);
        courses.add(newCourse);
        System.out.println("Course added successfully.");
    }

    public static void enrollStudent(Student student, Course course) {
        for (Course c : courses) {
            if (c.getCourseCode().equals(course.getCourseCode())) {
                if (c.getCurrentEnrollment() < c.getMaxCapacity()) {
                    student.enrollCourse(c);
                    c.incrementCurrentEnrollment();
                    System.out.println("Student enrolled in the course successfully.");
                } else {
                    System.out.println("Course is full. Cannot enroll more students.");
                }
                return;
            }
        }
        System.out.println("Course not found.");
    }

    public static void assignGrade(Student student, Course course, String grade) {
        student.assignGrade(course, grade);
    }

    public static void calculateOverallGrade(Student student) {
        int totalCredits = 0;
        int totalGradePoints = 0;
        for (Course course : student.getEnrolledCourses()) {
            if (!course.getGrade().isEmpty()) {
                // Assuming all courses have equal credits for simplicity
                totalCredits++;
                totalGradePoints += convertGradeToPoints(course.getGrade());
            }
        }
        double overallGrade = totalGradePoints / (double) totalCredits;
        System.out.println("Overall course grade for student " + student.getName() + ": " + overallGrade);
    }

    private static int convertGradeToPoints(String grade) {
        switch (grade) {
            case "A":
                return 4;
            case "B":
                return 3;
            case "C":
                return 2;
            case "D":
                return 1;
            default:
                return 0;
        }
    }
}
