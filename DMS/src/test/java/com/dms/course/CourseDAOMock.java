package com.dms.course;

import com.dms.course.interfaces.ICourseDAO;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOMock implements ICourseDAO {
    private static final String USERNAME = "admin";

    public Boolean isCourseIdAlreadyTaken(int courseId) {
        return courseId == 5000;
    }

    public Boolean addCourse(int courseId, String courseName, int facultyId, String timetable) {
        return courseId == 5000 && StringUtils.equals(courseName, "abc") && facultyId == 58754 && timetable == "Wed, Sat 3:00 PM to 5:00 PM";
    }

    public String removeCourse(String courseName) {
        if (StringUtils.equals(courseName, "abc")) {
            return courseName;
        }
        return null;
    }

    public boolean registerCourse(int courseId, String userName, int semester) throws SQLException {
        if (courseId == 5000 && userName == "Moksh" && semester == 1) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Course> getCourses() throws SQLException {
        ArrayList<Course> courseList = new ArrayList<>();
        Course course = new Course();
        course.setCourseId(5906);
        course.setCourseName("abc");
        courseList.add(course);
        return courseList;
    }

    public boolean withdrawCourse(int courseId, String userName) throws SQLException {
        if (courseId == 5000 && userName == "Moksh") {
            return true;
        } else {
            return false;
        }
    }

    public List<String> retrieveTimetable(String username) throws SQLException {
        List<String> timetable = new ArrayList<>();
        if (StringUtils.equals(username, USERNAME)) {
            timetable.add("Monday 13:00 to 14:30");
            return timetable;
        }
        return timetable;
    }
}