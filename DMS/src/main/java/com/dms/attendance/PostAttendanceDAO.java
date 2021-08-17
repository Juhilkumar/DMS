package com.dms.attendance;

import com.dms.attendance.interfaces.IPostAttendanceDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import org.apache.commons.lang3.StringUtils;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PostAttendanceDAO implements IPostAttendanceDAO {
    private final ISqlConnection connectionManager;
    private static int DAYSPRESENT = -1;
    private static int TOTALDAYS = -1;
    private static final String PRESENT= "present";
    
    public PostAttendanceDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public boolean postAttendance(int studentId, int courseId,String attendanceState) throws SQLException {
        try{
            String query = "select daysPresent,totalDays from CourseRegistrationDetails where studentId = "+studentId+" AND courseId = "+courseId;
            connectionManager.executeRead(query);
            ResultSet result = connectionManager.executeResult(query);
            while(result.next()) {
                DAYSPRESENT = result.getInt(1);
                TOTALDAYS = result.getInt(2);
            }
            if(StringUtils.equals(attendanceState,PRESENT)) {
                DAYSPRESENT++;
                TOTALDAYS++;
            }
            else{
                TOTALDAYS++;
            }
            String updateQuery = "update CourseRegistrationDetails set daysPresent= "+DAYSPRESENT+",totalDays="+TOTALDAYS+" where studentId = "+studentId+" AND courseId = "+courseId;
            connectionManager.executeWrite(updateQuery);
            return true;
        }catch (SQLException se) {
            se.printStackTrace();
        }finally {
            connectionManager.closeConnection();
        }
        return false;
    }
}