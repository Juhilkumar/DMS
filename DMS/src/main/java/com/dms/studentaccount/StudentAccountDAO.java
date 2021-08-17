package com.dms.studentaccount;

import com.dms.studentaccount.interfaces.IStudentAccountDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentAccountDAO implements IStudentAccountDAO {
    private final ISqlConnection connectionManager;
    private static final int COURSE_FEES = 3000;
    private static final int COURSE_REFUND = 1500;

    public StudentAccountDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public StudentAccountModel getStudentAccountDetails(String userName) throws SQLException {

        StudentAccountModel studentAccount = new StudentAccountModel();
        int studentId = 0;
        try {
            String studentIdQuery = "SELECT studentID FROM Student where userName = '" + userName + "'";
            connectionManager.executeRead(studentIdQuery);
            ResultSet resultSet = connectionManager.executeResult(studentIdQuery);

            while (resultSet.next()) {
                studentId = resultSet.getInt("studentID");
            }

            String getStudentAccountDetailQuery = "SELECT * FROM StudentAccount WHERE studentId =" + studentId;
            connectionManager.executeRead(getStudentAccountDetailQuery);
            resultSet = connectionManager.executeResult(getStudentAccountDetailQuery);
            while (resultSet.next()) {
                studentAccount.setStudentId(resultSet.getInt("studentId"));
                studentAccount.setBilledAmount(resultSet.getInt("billedAmount"));
                studentAccount.setUnbilledAmount(resultSet.getInt("unbilledAmount"));
                studentAccount.setTotalAmount(resultSet.getInt("totalAmount"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return studentAccount;
    }


    public void deductMoney(int studentId) throws SQLException {

        try {
            String deductAmountFromAccount = "UPDATE StudentAccount SET billedAmount = billedAmount +" + COURSE_FEES + ", unbilledAmount = unbilledAmount - " + COURSE_FEES + " WHERE unbilledAmount >= 0 AND studentId =" + studentId;
            connectionManager.executeWrite(deductAmountFromAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
    }

    public void depositMoney(int studentId) throws SQLException{

        try {
            String depositAmountIntoAccount = "UPDATE StudentAccount SET billedAmount = billedAmount -" + COURSE_REFUND + ", unbilledAmount = unbilledAmount + " + COURSE_REFUND + " WHERE unbilledAmount >= 0 AND studentId =" + studentId;
            connectionManager.executeWrite(depositAmountIntoAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
    }
}
