package com.dms.attendance.interfaces;

import java.sql.SQLException;

public interface IGetAttendanceDAO {
    int getAttendance(String username,int courseId) throws SQLException;
}