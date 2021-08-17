package com.dms.courserating;

import com.dms.courserating.interfaces.ICourseRatingDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRatingDAO implements ICourseRatingDAO {

    private final ISqlConnection connectionManager;

    public CourseRatingDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public boolean postCourseRating(int courseId, String userName, int ratingPoint) throws SQLException {

        boolean courseRatingGivenDAO = false;
        int studentId = 0;
        int courseIdRegistered = 0;
        int studentIdRating = 0;
        try {

            String studentIdQuery = "SELECT studentId FROM Student where userName = '" + userName + "'";
            connectionManager.executeRead(studentIdQuery);
            ResultSet resultSet = connectionManager.executeResult(studentIdQuery);
            while (resultSet.next()) {
                studentId = resultSet.getInt("studentID");
            }
            String postCourseRatingQuery = "INSERT INTO CourseRating VALUES(" + studentId + "," + courseId + "," + ratingPoint + ")";

            String checkIfUserRegisteredCourseAlready = "SELECT studentId, courseId FROM CourseRegistrationDetails where courseId = " + courseId + " and studentId =" + studentId;
            resultSet = connectionManager.executeResult(checkIfUserRegisteredCourseAlready);
            while (resultSet.next()) {
                courseIdRegistered = resultSet.getInt("courseId");
            }

            String isStudentAlreadyGivenRating = "SELECT studentId, courseId FROM CourseRating where courseId = " + courseId + " and studentId =" + studentId;
            resultSet = connectionManager.executeResult(isStudentAlreadyGivenRating);
            while (resultSet.next()) {
                studentIdRating = resultSet.getInt("studentId");
            }

            String updateCourseRating = "UPDATE Course SET courseRating = (SELECT AVG(rating) FROM CourseRating WHERE courseId=" + courseId + ") WHERE Course.courseId =" + courseId;

            if (courseId == courseIdRegistered && studentId != studentIdRating) {
                connectionManager.executeWrite(postCourseRatingQuery);
                connectionManager.executeWrite(updateCourseRating);
                courseRatingGivenDAO = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return courseRatingGivenDAO;
    }
}
