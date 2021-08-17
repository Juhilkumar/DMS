package com.dms.attendance;

import com.dms.attendance.interfaces.IGetCourseDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetCourseDAO implements IGetCourseDAO {
    private final ISqlConnection connectionManager;

    public GetCourseDAO()
    {
        connectionManager = new SqlConnectionImpl();
    }

    public List<Integer> getCourseID(String username) throws SQLException{
        List<Integer> course_id = new ArrayList<>();
        try {
            String query = "select courseId from CourseRegistrationDetails where studentId=(select studentId from Student where userName = " + "'" + username + "')";
            connectionManager.executeRead(query);
            ResultSet result = connectionManager.executeResult(query);

            while (result.next()) {
                course_id.add(result.getInt(1));
            }
        }catch (SQLException se) {
            se.printStackTrace();
            }finally {
                connectionManager.closeConnection();
            }
        return course_id;
    }
}