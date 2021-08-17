package com.dms.salary;

import com.dms.salary.interfaces.IFacultySalary;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FacultySalaryDAO implements IFacultySalary {
    private final ISqlConnection connectionManager;
    public FacultySalaryDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    Map<Integer, String> facultyDetails = new HashMap<Integer,String>();

    public Map<Integer, String> getFacultySalaryDetails() throws SQLException{
        try {
            String sql = "SELECT Faculty.facultyId , Faculty.facultyDesignation from Faculty";
            connectionManager.executeRead(sql);
            ResultSet result = connectionManager.executeResult(sql);
            while (result.next()) {
                facultyDetails.put(result.getInt("facultyId"),result.getString("facultyDesignation"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally{
            connectionManager.closeConnection();
        }
        return facultyDetails;
    }

    public boolean insertFacultySalary(int facultyID, int salary, String month, int year) throws SQLException {
        boolean salaryUpdated = false;
        try {
            String sql = "insert into Salary (facultyId,salary, month, year) " +
                    "values ('" + facultyID + "','" + salary + "','" + month + "','" + year + "')";

            connectionManager.executeWrite(sql);
            salaryUpdated = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally{
            connectionManager.closeConnectionWithoutResultset();
        }
        return salaryUpdated;
    }

    public boolean updateFacultySalary(int facultyID, int salary, String month, int year) throws SQLException{
        boolean salaryUpdated = false;
        try {
            String sql = "update Salary \n" +
                    "set Salary.salary='" + salary + "'\n" +
                    "where Salary.facultyId = '" + facultyID + "' and Salary.month = '" + month + "' and Salary.year = '" + year + "'";
            connectionManager.executeWrite(sql);
            salaryUpdated = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally{
            connectionManager.closeConnectionWithoutResultset();
        }
        return salaryUpdated;

    }

    public boolean checkFacultySalary(int facultyID, String month, int year) throws SQLException {
        boolean salaryExists = false;
        try{
            String sql = "select * from Salary where Salary.facultyId ='" + facultyID + "'and Salary.month = '" + month + "' and Salary.year = '" + year + "'";
            connectionManager.executeRead(sql);
            ResultSet result = connectionManager.executeResult(sql);
            if (result.next()) {
                salaryExists = true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally{
            connectionManager.closeConnection();
        }
      return salaryExists;
    }

    public float getCourseRatingAvg( int FacultyID) throws SQLException{
        float averageOfCourseRating = 0;
        try {
            String sql = "select Avg(Course.courseRating) from Course where facultyId ='" + FacultyID + "'";
            connectionManager.executeRead(sql);
            ResultSet result = connectionManager.executeResult(sql);
            if(result.next()) {
                averageOfCourseRating=result.getFloat("Avg(Course.courseRating)");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally{
            connectionManager.closeConnection();
        }
        return averageOfCourseRating;
    }
}
