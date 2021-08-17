package com.dms.attendance.interfaces;

import java.sql.SQLException;

public interface IPostAttendanceDAO {
    boolean postAttendance(int studentId, int courseId,String attendance_state) throws SQLException;
}