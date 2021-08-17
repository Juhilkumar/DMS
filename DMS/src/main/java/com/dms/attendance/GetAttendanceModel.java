package com.dms.attendance;

import com.dms.attendance.interfaces.IGetAttendanceDAO;
import com.dms.attendance.interfaces.IGetAttendanceModel;
import java.sql.SQLException;

public class GetAttendanceModel implements IGetAttendanceModel {
    private final IGetAttendanceDAO iGetAttendanceDao;
    public GetAttendanceModel(IGetAttendanceDAO iGetAttendanceDao) {
        this.iGetAttendanceDao = iGetAttendanceDao;
    }

    public int retrievingAttendance(String userName, int courseId) throws SQLException {
        int attendance = iGetAttendanceDao.getAttendance(userName,courseId);
        return attendance;
    }
}