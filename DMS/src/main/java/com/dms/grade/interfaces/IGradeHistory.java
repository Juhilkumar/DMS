package com.dms.grade.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IGradeHistory {
    List<String> getRegisteredCourses(String userName) throws SQLException;
    Map<Integer, Integer> getGrades(String userName, String courseName) throws SQLException;
    List allGrades(String userName, int semester) throws SQLException;
}
