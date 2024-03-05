public class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    // Getter methods for courseCode, name, and maxCapacity
    public String getCourseCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Method to increment totalEnrolledStudents
    public static void incrementTotalEnrolledStudents() {
        totalEnrolledStudents++;
    }

    // Static method to get total enrolled students
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}
