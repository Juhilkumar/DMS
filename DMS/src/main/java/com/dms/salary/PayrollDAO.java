package com.dms.salary;

import com.dms.salary.interfaces.IPayrollDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PayrollDAO implements IPayrollDAO {
    private final ISqlConnection connectionManager;
    public PayrollDAO() {
        connectionManager = new SqlConnectionImpl();
    }
    int i = 1;

 public Map<Integer, List> getFacultySalaryDetails(String userName, String month, int year) throws SQLException {

        Map<Integer, List> facultySalaryList = new LinkedHashMap<Integer, List>();
        try {
            String sql = "select Salary.facultyId, Salary.salary, Salary.month,Salary.year from Salary \n" +
                    "                        inner join Faculty on Salary.facultyId = Faculty.facultyId\n" +
                    "                        inner join User on Faculty.userId = User.userId\n" +
                    "                        where User.userName='" + userName + "' and Salary.month='" + month + "' and Salary.year='" + year + "'";
            connectionManager.executeRead(sql);
            ResultSet result = connectionManager.executeResult(sql);
            while (result.next()) {
                List salaryInfo = new ArrayList<>();
                salaryInfo.add(result.getInt("facultyId"));
                salaryInfo.add(result.getInt("salary"));
                salaryInfo.add(result.getString("month"));
                salaryInfo.add(result.getInt("year"));
                facultySalaryList.put(i, salaryInfo);
                i = i + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return facultySalaryList;
    }
}

