package com.dms.grade.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IPostGradesModel {
    List<String> courseNamesList(String userName) throws SQLException;
    Map<Integer, List<Integer>> getStudentDetails(String userName, String courseName) throws SQLException;
    boolean  postGrades(int marks, int studentID, int courseId) throws SQLException;
}
