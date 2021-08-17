package com.dms.meeting;

import com.dms.meeting.interfaces.IScheduleMeeting;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScheduleMeetingDAO implements IScheduleMeeting {
    private static final int VALUE =1;
    private final ISqlConnection connectionManager;
    public ScheduleMeetingDAO() {
        connectionManager = new SqlConnectionImpl();
    }
    int keyOfMap = 1;
    int studentID;

    public Map<Integer, List> facultyDetails(String userName) throws SQLException {
            Map<Integer, List> facultyDetailsList = new LinkedHashMap<Integer, List>();
            try {
                String sql = "select Course.courseId, Course.courseName,Course.facultyId from Course\n" +
                        "inner join CourseRegistrationDetails on CourseRegistrationDetails.courseId = Course.courseId\n" +
                        "inner join Student on Student.studentId = CourseRegistrationDetails.studentId \n" +
                        "inner join User on  Student.userId = User.UserId\n" +
                        "where User.userName = '" + userName + "'";
                connectionManager.executeRead(sql);
                ResultSet result = connectionManager.executeResult(sql);
                while (result.next()) {
                    List courseInfo = new ArrayList<>();
                    courseInfo.add(result.getInt("courseId"));
                    courseInfo.add(result.getString("courseName"));
                    courseInfo.add(result.getInt("facultyId"));
                    facultyDetailsList.put(keyOfMap, courseInfo);
                    keyOfMap = keyOfMap + VALUE;
                }

            } catch (SQLException e) {
            } finally {
                connectionManager.closeConnection();
            }
            return facultyDetailsList;
        }

        public int getStudentID(String userName) throws SQLException{
            try {
                String sql = "select studentId from Student where userName = '" + userName + "' ";
                connectionManager.executeRead(sql);
                ResultSet result = connectionManager.executeResult(sql);

                 if(result.next()) {
                        studentID = result.getInt("studentId");
                }
            }
            catch (SQLException e) {
            } finally {
                connectionManager.closeConnection();
            }
            return studentID;

        }

        public boolean checkSlots(int facultyID, Date date, String slot) throws SQLException{
            boolean isSlotAvailable = true;
            try {
                String sql = "select facultyId, date,slot from Meeting\n" +
                        "where facultyId ='"+facultyID+"' and date = '"+date+"' and slot ='"+slot+"'";
                connectionManager.executeRead(sql);
                ResultSet result = connectionManager.executeResult(sql);

                if(result.next()) {
                    isSlotAvailable = false;
                }
            }
            catch (SQLException e) {
            } finally {
                connectionManager.closeConnection();
            }
            return isSlotAvailable;
        }

        public boolean bookSlot(int facultyID, Date date, String slot, int studentID) throws SQLException{
            boolean isSlotBooked = false;
            try {
                String sql = "insert into Meeting (facultyId, date, slot , studentId)" +
                        "values ('" + facultyID+ "','" + date + "','" + slot + "','" + studentID + "')";

                connectionManager.executeWrite(sql);
                isSlotBooked = true;
            }
            catch (SQLException e) {
            } finally{
                connectionManager.closeConnectionWithoutResultset();
            }
            return isSlotBooked;
        }

        public String getFacultyMail(int facultyID) throws SQLException{
        String mailID = "";
            try {
                String sql = "select User.email from User\n" +
                        "inner join Faculty on Faculty.userId = User.userId\n" +
                        "where Faculty.facultyId = '" + facultyID+ "'";
                connectionManager.executeRead(sql);
                ResultSet result = connectionManager.executeResult(sql);
                if(result.next()) {
                    mailID = result.getString("email");
                }
            }
            catch (SQLException e) {
            } finally {
                connectionManager.closeConnection();
            }
            return mailID;
        }

    }

