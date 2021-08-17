package com.dms.grade.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IGradeHistoryModel {
    List<String> courseNamesList(String userName) throws SQLException;
    Map<Integer, String> calculateGrades(String userName, String courseName) throws SQLException;
    String scoreToLetterGrade(int finalgrade);
    double calculateCgpa(String userName, int semester) throws SQLException;
}
