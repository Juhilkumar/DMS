package com.dms.user;

import com.dms.user.abstarctfactory.UserAbstractFactory;
import com.dms.user.interfaces.IUserModel;
import com.dms.user.interfaces.IUserDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static final String USER_NAME_COLUMN = "username";
    private static final String FIRST_NAME_COLUMN = "firstName";
    private static final String USER_ROLE_COLUMN = "role";
    private static final String USER_STATUS_COLUMN = "status";
    private static final int DEPOSIT_MONEY = 25000;
    private static final String USER_EMAIL_COLUMN = "email";

    UserAbstractFactory userAbstractFactory = UserAbstractFactory.instance();
    private final ISqlConnection connectionManager;

    public UserDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public List<IUserModel> getUserList() throws SQLException {
        List<IUserModel> userList = new ArrayList<>();
        try {
            String selectQuery = "select * from User";
            connectionManager.executeRead(selectQuery);
            ResultSet result = connectionManager.executeResult(selectQuery);
            while (result.next()) {
                IUserModel iUserModel = userAbstractFactory.createUser();
                iUserModel.setUsername(result.getString(USER_NAME_COLUMN));
                iUserModel.setFirstName(result.getString(FIRST_NAME_COLUMN));
                iUserModel.setRole(result.getString(USER_ROLE_COLUMN));
                iUserModel.setStatus(result.getString(USER_STATUS_COLUMN));
                userList.add(iUserModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return userList;
    }

    public String approveUser(String username) throws SQLException {
        int studentId=0;
        try {
            String studentIdQuery = "SELECT studentId FROM Student WHERE userName = '" + username + "'";
            connectionManager.executeRead(studentIdQuery);
            ResultSet resultSet = connectionManager.executeResult(studentIdQuery);
            while (resultSet.next()) {
                studentId = resultSet.getInt("studentId");
            }
            String approveQuery = "Update User SET status='approved' WHERE username = '" + username + "'";
            String setStudentAccount  = "INSERT INTO StudentAccount (studentId, unbilledAmount, totalAmount) VALUES (" +studentId+ "," +DEPOSIT_MONEY+ "," +DEPOSIT_MONEY+")";
            connectionManager.executeWrite(approveQuery);
            connectionManager.executeWrite(setStudentAccount);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return username;
    }

    public String removeUser(String username) throws SQLException {
        try {
            String deleteQuery = "DELETE FROM User WHERE username = '" + username + "'";
            connectionManager.executeWrite(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return username;
    }

    public int getUserId(String username) throws SQLException {
        int userId = 0;
        try {
            String fetchUserId = "SELECT userId FROM User WHERE username = '" + username + "'";
            connectionManager.executeRead(fetchUserId);
            ResultSet resultSet = connectionManager.executeResult(fetchUserId);
            while (resultSet.next()) {
                userId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return userId;
    }

    public String getUserEmail(int userId) throws SQLException {
        String mailId = "";
        try {
            String selectQuery = "SELECT email FROM User WHERE userId = '" + userId + "'";
            connectionManager.executeRead(selectQuery);
            ResultSet resultSet = connectionManager.executeResult(selectQuery);
            if (resultSet.next()) {
                mailId = resultSet.getString(USER_EMAIL_COLUMN);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return mailId;
    }
}
