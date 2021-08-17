package com.dms.authentication;

import com.dms.authentication.interfaces.IUserLogin;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO implements IUserLogin {
    private static final String roleInvalid = "Invalid Role";
    private static final String DEFAULT_STATUS = "statusNotApproved";
    private static ISqlConnection connectionManager;
    public LoginDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public List userInformation(String userID, String password) throws SQLException {
        List userInfo  = new ArrayList<>();
        try {
            String sql1 = "select * from User where userName='" + userID + "' and password='" + password + "'";
            connectionManager.executeRead(sql1);
            ResultSet result = connectionManager.executeResult(sql1);
            if (result.next()) {
                if ((StringUtils.equals(userID,result.getString("userName"))) &&
                        StringUtils.equals(password,result.getString("password"))){
                    userInfo.add(result.getString("role"));
                    userInfo.add(result.getString("status"));
                }
            }
            else {
                userInfo.add(roleInvalid);
                userInfo.add(DEFAULT_STATUS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connectionManager.closeConnection();
        }
        return userInfo;
    }
}



