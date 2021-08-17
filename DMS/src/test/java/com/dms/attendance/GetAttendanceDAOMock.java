package com.dms.attendance;

import com.dms.attendance.interfaces.IGetAttendanceDAO;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;

public class GetAttendanceDAOMock implements IGetAttendanceDAO {
    private static final String USERNAME = "Parth";
    private static final int COURSE = 5100;
    private static final int ATTENDANCE = 50;

    public int getAttendance(String username, int courseId) throws SQLException {
        if (StringUtils.equals(username, USERNAME) && courseId == COURSE) {
            return ATTENDANCE;
        } else {
            return -1;
        }
    }
}