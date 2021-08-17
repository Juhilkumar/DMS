package com.dms.attendance;

import com.dms.attendance.interfaces.IPostAttendanceDAO;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;

public class PostAttendanceDAOMock implements IPostAttendanceDAO {
    private static final int STUDENTID = 22123;
    private static final int COURSEID = 5308;
    private static final String ATTENDANCE = "present";

    public boolean postAttendance(int studentId, int courseId, String attendanceState) throws SQLException {
        if (studentId == STUDENTID && courseId == COURSEID && StringUtils.equals(attendanceState, ATTENDANCE)) {
            return true;
        } else {
            return false;
        }
    }
}