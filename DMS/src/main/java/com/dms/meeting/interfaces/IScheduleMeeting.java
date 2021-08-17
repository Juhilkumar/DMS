package com.dms.meeting.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IScheduleMeeting {

    Map<Integer, List> facultyDetails(String userName) throws SQLException;
    int getStudentID(String userName) throws SQLException;
    boolean checkSlots(int facultyID, Date date, String slot) throws SQLException;
    boolean bookSlot(int facultyID, Date date, String slot, int studentID) throws SQLException;
    String getFacultyMail(int facultyID) throws SQLException;
}
