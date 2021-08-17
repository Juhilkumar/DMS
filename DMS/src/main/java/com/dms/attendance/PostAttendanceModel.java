package com.dms.attendance;

import com.dms.attendance.interfaces.IPostAttendanceDAO;
import com.dms.attendance.interfaces.IPostAttendanceModel;
import java.sql.SQLException;


public class PostAttendanceModel implements IPostAttendanceModel {
    private final IPostAttendanceDAO iPostAttendanceDao;
    public PostAttendanceModel(IPostAttendanceDAO iPostAttendanceDao) {
        this.iPostAttendanceDao = iPostAttendanceDao;
    }

    public boolean postAttendance(int studentId, int courseId, String attendanceState) throws SQLException {
       boolean result = iPostAttendanceDao.postAttendance(studentId,courseId,attendanceState);
       return result;
    }
}