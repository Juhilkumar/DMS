package com.dms.classroom;

import com.dms.classroom.interfaces.IClassroomDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassroomDAO implements IClassroomDAO {

    private final ISqlConnection connectionManager;

    public ClassroomDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public List<ClassroomModel> getClassroom(String userName) throws SQLException {
        int facultyId = 0;
        List<ClassroomModel> classroomList = new ArrayList<>();
        ClassroomModel classroomSchedule;
        try {
            String facultyIdQuery = "SELECT facultyId FROM Faculty WHERE userName ='" + userName + "'";
            connectionManager.executeRead(facultyIdQuery);
            ResultSet resultSet = connectionManager.executeResult(facultyIdQuery);
            while (resultSet.next()) {
                facultyId = resultSet.getInt("facultyId");
            }

            String getClassroom = "SELECT courseId, classTopic, scheduleDate, startTime, endTime FROM Classroom WHERE facultyId =" + facultyId;
            resultSet = connectionManager.executeResult(getClassroom);
            while (resultSet.next()) {
                classroomSchedule = new ClassroomModel();
                classroomSchedule.setCourseId(resultSet.getInt("courseId"));
                classroomSchedule.setClassTopic(resultSet.getString("classTopic"));
                classroomSchedule.setScheduleDate(resultSet.getDate("scheduleDate"));
                classroomSchedule.setStartTime(resultSet.getString("startTime"));
                classroomSchedule.setEndTime(resultSet.getString("endTime"));
                classroomList.add(classroomSchedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return classroomList;
    }

    public boolean postClassroomSchedule(String userName, int courseId, String classTopic, Date scheduleDate, String startTime, String endTime) throws SQLException {
        boolean isClassroomSchedulePosted = false;
        int facultyId = 0;
        try {
            String facultyIdQuery = "SELECT facultyId FROM Faculty where userName = '" + userName + "'";
            connectionManager.executeRead(facultyIdQuery);
            ResultSet resultSet = connectionManager.executeResult(facultyIdQuery);
            while (resultSet.next()) {
                facultyId = resultSet.getInt("FacultyId");
            }
            String classroomScheduleQuery = "INSERT INTO Classroom (courseId,facultyId,classTopic,scheduleDate,startTime,endTime) VALUES (" + courseId + "," + facultyId + ",'" + classTopic + "','" + scheduleDate + "','" + startTime + "','" + endTime + "')";
            connectionManager.executeWrite(classroomScheduleQuery);
            isClassroomSchedulePosted = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return isClassroomSchedulePosted;
    }
}
