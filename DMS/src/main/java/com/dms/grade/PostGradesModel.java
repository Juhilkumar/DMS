package com.dms.grade;

import com.dms.grade.interfaces.IPostGrades;
import com.dms.grade.interfaces.IPostGradesModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PostGradesModel implements IPostGradesModel {
    private final IPostGrades iPostGrades;
    private static final int minMarks = 0;
    private static final int maxMarks = 100;
    public PostGradesModel(IPostGrades iPostGrades) {
        this.iPostGrades = iPostGrades;
    }

    public List<String> courseNamesList(String userName) throws SQLException {
        List<String> courseNames = iPostGrades.getCourseNames(userName);
        return courseNames;
    }

    public Map<Integer, List<Integer>> getStudentDetails(String userName, String courseName) throws SQLException {
        Map<Integer, List<Integer>> studentDetails = iPostGrades.getStudentDetails(userName,courseName);
        return studentDetails;
    }

    public boolean postGrades(int marks, int studentID, int courseId) throws SQLException {
        boolean gradeUpdated = false;
        if (marks >= minMarks && marks <= maxMarks) {
            gradeUpdated = iPostGrades.postGrades(marks, studentID, courseId);
        }
        return gradeUpdated;
    }
}
