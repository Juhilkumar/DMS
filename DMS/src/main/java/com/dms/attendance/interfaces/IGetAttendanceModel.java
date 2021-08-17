package com.dms.attendance.interfaces;

import java.sql.SQLException;

public interface IGetAttendanceModel {
    int retrievingAttendance(String userName, int courseId) throws SQLException;
}