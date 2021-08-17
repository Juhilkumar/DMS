package com.dms.timetable;

import com.dms.timetable.interfaces.ITimetableStudentDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TimetableStudentDAO implements ITimetableStudentDAO {
    private final ISqlConnection connectionManager;

    public TimetableStudentDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public Map<Integer,String> getTimetable(String username) throws SQLException {
        Map<Integer,String> timetable = new HashMap<>();
        try{
            String query = "select timetable, courseId from Course where courseId IN (select courseId from CourseRegistrationDetails where studentId=(select studentId from Student where userName = '"+username+"'));";
            connectionManager.executeRead(query);
            ResultSet result = connectionManager.executeResult(query);
            while(result.next()) {
                timetable.put(result.getInt(2),result.getString(1));
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            connectionManager.closeConnection();
        }
        return timetable;
    }
}