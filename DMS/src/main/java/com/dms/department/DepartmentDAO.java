package com.dms.department;

import com.dms.department.interfaces.IDepartmentDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDAO implements IDepartmentDAO {
    private static ISqlConnection connectionManager;

    public DepartmentDAO(){
        connectionManager = new SqlConnectionImpl();
    }

    public List<String> getCourses() throws SQLException {
        List<String> course_name = new ArrayList<>();
        try{
            String query = "select courseName from Course";
            connectionManager.executeRead(query);
            ResultSet result = connectionManager.executeResult(query);
            while(result.next()) {
                course_name.add(result.getString(1));
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            connectionManager.closeConnection();
        }
        return course_name;
    }

    public Map<String,String> getFaculty() throws SQLException{
        Map<String,String> faculty = new HashMap<>();
        try{
            String query = "select userName, facultyDesignation from Faculty";
            connectionManager.executeRead(query);
            ResultSet result = connectionManager.executeResult(query);
            while(result.next()) {
                faculty.put(result.getString(1),result.getString(2));
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            connectionManager.closeConnection();
        }
        return faculty;
    }
}