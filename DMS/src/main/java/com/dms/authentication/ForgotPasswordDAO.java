package com.dms.authentication;

import com.dms.authentication.interfaces.IForgotPasswordDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import org.apache.commons.lang3.StringUtils;
import java.sql.*;

public class ForgotPasswordDAO implements IForgotPasswordDAO {
    private final ISqlConnection connectionManager;

    public ForgotPasswordDAO()
    {
        connectionManager = new SqlConnectionImpl();
    }

    @Override
    public boolean updatePassword(String username, String emailId, String securityAnswer, String password, String reenterPassword) throws SQLException {
        PasswordVerify passwordVerify = new PasswordVerify();
        String email = null;
        String answer = null;
        try{
            String query = "select email, securityAnswer from User where userName='"+username+"'";
            connectionManager.executeRead(query);
            ResultSet resultSet = connectionManager.executeResult(query);
            while(resultSet.next()) {
                email = resultSet.getString(1);
                answer = resultSet.getString(2);
            }
            boolean passwordEqual = passwordVerify.passwordVerify(password,reenterPassword);
            if(StringUtils.equals(email,emailId) && StringUtils.equals(answer,securityAnswer) && passwordEqual) {
                String updateQuery = "update User set password = '"+password+"' where userName = '"+username+"'";
                connectionManager.executeWrite(updateQuery);
                return true;
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            connectionManager.closeConnection();
        }
        return false;
    }
}