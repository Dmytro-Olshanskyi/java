package ua.com.foxminded;

public class Course {

    private int courseId;
    private String courseName;
    private String getCourseDescription;

    public Course(int courseId, String courseName, String getCourseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.getCourseDescription = getCourseDescription;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getGetCourseDescription() {
        return getCourseDescription;
    }
}
