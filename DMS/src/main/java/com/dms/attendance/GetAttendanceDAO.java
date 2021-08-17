package com.dms.attendance;

import com.dms.attendance.interfaces.IGetAttendanceDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAttendanceDAO implements IGetAttendanceDAO {
    private final ISqlConnection connectionManager;
    private static int DAYSPRESENT = -1;
    private static int TOTALDAYS = -1;

    public GetAttendanceDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public int getAttendance(String userName,int courseId) throws SQLException {
        try{
            String query = "select daysPresent,totalDays from CourseRegistrationDetails where studentId = (select studentId from Student where userName="+"'"+userName+"'"+") AND courseId = "+courseId;
            connectionManager.executeRead(query);
            ResultSet result = connectionManager.executeResult(query);

            while(result.next()) {
                DAYSPRESENT = result.getInt(1);
                TOTALDAYS = result.getInt(2);
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            connectionManager.closeConnection();
        }
        AttendancePercentage attendancePercentage = new AttendancePercentage();
        int percentage  = attendancePercentage.calculatePercentage(DAYSPRESENT,TOTALDAYS);
        return percentage;
    }
}