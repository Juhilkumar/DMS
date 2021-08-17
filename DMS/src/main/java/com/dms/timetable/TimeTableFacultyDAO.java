package com.dms.timetable;

import com.dms.timetable.interfaces.ITimeTableFacultyDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TimeTableFacultyDAO implements ITimeTableFacultyDAO {
    private final ISqlConnection connectionManager;

    public TimeTableFacultyDAO()
    {
        connectionManager = new SqlConnectionImpl();
    }

    public Map<Integer, String> getTimetable(String username) throws SQLException {
        Map<Integer,String> timetable = new HashMap<>();
        try{
            String query = "select timetable, courseId from Course where facultyId IN (select facultyId from Faculty where userName='"+username+"');";
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