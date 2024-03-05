import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course newCourse = new Course(courseCode, name, maxCapacity);
        courses.add(newCourse);
    }

    public static void enrollStudent(Student student, Course course) {
        if (Course.getTotalEnrolledStudents() < course.getMaxCapacity()) {
            student.enrollCourse(course);
            Course.incrementTotalEnrolledStudents();
        } else {
            System.out.println("Course is full, cannot enroll student.");
        }
    }

    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
    }
}
