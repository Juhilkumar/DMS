package com.dms.grade;

import com.dms.grade.interfaces.IGradeHistory;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeHistoryDAO implements IGradeHistory {
    private static final int DEFAULT = 0;
    private final ISqlConnection connectionManager;
    public GradeHistoryDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public List<String> getRegisteredCourses(String userName) throws SQLException {
        List<String> courseNames = new ArrayList<>();
        try {
            String sql = " select courseName from Course\n" +
                    " inner join CourseRegistrationDetails on CourseRegistrationDetails.courseId = Course.courseId\n" +
                    " inner join Student on Student.studentId = CourseRegistrationDetails.studentId\n" +
                    " inner join User on User.userId = Student.userId\n" +
                    " where User.userName='" + userName + "'";
            connectionManager.executeRead(sql);
            ResultSet result = connectionManager.executeResult(sql);
            while (result.next()) {
                courseNames.add(result.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return courseNames;
    }

    public Map<Integer, Integer> getGrades(String userName, String courseName) throws SQLException {
        Map<Integer, Integer> gradeList = new HashMap<Integer, Integer>();
        try {
            String sql = "select CourseRegistrationDetails.courseId , CourseRegistrationDetails.grade from CourseRegistrationDetails \n" +
                    "                    inner join Student on CourseRegistrationDetails.studentId = Student.studentId\n" +
                    "                    inner join Course on CourseRegistrationDetails.courseId = Course.courseId\n" +
                    "                    inner join User on Student.userId = User.userId\n" +
                    "                    where User.userName='" + userName + "' and Course.courseName='" + courseName + "' ";
            connectionManager.executeRead(sql);
            ResultSet result = connectionManager.executeResult(sql);
            while (result.next()) {
                gradeList.put(result.getInt("courseId"), result.getInt("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return gradeList;
    }

    public List<Integer> allGrades(String userName, int semester) throws SQLException {
        List<Integer> marks = new ArrayList<Integer>();
        try {
            String sql = "select CourseRegistrationDetails.grade from CourseRegistrationDetails \n" +
                    "                    inner join Student on CourseRegistrationDetails.studentId = Student.studentId\n" +
                    "                    inner join Course on CourseRegistrationDetails.courseId = Course.courseId\n" +
                    "                    inner join User on Student.userId = User.userId\n" +
                    "                    where User.userName='" + userName + "' and CourseRegistrationDetails.semester ='" + semester + "'";
            connectionManager.executeRead(sql);
            ResultSet result = connectionManager.executeResult(sql);
            while (result.next()) {
                marks.add(result.getInt("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        if (marks.size() > DEFAULT) {
            return marks;
        } else {
            marks.add(DEFAULT);
        }
        return marks;
    }
}

