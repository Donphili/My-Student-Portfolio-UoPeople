import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private int id;
    private Map<Course, Integer> gradesMap;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.gradesMap = new HashMap<>();
    }

    // Getter and setter methods for name and id

    public void enrollCourse(Course course) {
        // Implementation to enroll student in a course
    }

    public void assignGrade(Course course, int grade) {
        gradesMap.put(course, grade);
    }
}
