import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int ID;
    private List<Course> enrolledCourses;

    public Student(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void assignGrade(Course course, String grade) {
        for (Course enrolledCourse : enrolledCourses) {
            if (enrolledCourse.equals(course)) {
                enrolledCourse.setGrade(grade);
                return;
            }
        }
        System.out.println("Student is not enrolled in the specified course.");
    }
}
