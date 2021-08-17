package com.dms.course.interfaces;

import com.dms.course.Course;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ICourseDAO {
    Boolean isCourseIdAlreadyTaken(int courseId) throws SQLException;
    Boolean addCourse(int courseId, String courseName, int facultyId, String timetable) throws SQLException;
    String removeCourse(String courseName) throws SQLException;
    boolean registerCourse(int courseId, String useName, int semester) throws SQLException;
    ArrayList<Course> getCourses() throws SQLException;
    boolean withdrawCourse(int courseId, String userName) throws SQLException;
    List<String> retrieveTimetable(String userName) throws SQLException;
}
