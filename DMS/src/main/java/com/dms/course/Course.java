package com.dms.course;

public class Course {
    private int courseId ;
    private String courseName;
    private int facultyId;
    private int courseCredit;
    private float courseRating;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public float getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(float courseRating) {
        this.courseRating = courseRating;
    }

}
