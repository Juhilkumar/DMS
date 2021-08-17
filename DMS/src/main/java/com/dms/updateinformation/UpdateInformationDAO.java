package com.dms.updateinformation;

import com.dms.updateinformation.interfaces.IUpdateInformationDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateInformationDAO implements IUpdateInformationDAO {
    private final ISqlConnection connectionManager;

    public UpdateInformationDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public List<String> getInfo(String userName) throws SQLException{
        List<String> details = new ArrayList<>();
        try{
            String query = "select firstName,lastName,dob,email,password from User where userName='"+userName+"'";
            connectionManager.executeRead(query);
            ResultSet result = connectionManager.executeResult(query);
            while (result.next()){
                details.add(result.getString(1));
                details.add(result.getString(2));
                details.add(result.getString(3));
                details.add(result.getString(4));
                details.add(result.getString(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connectionManager.closeConnection();
        }
        return details;
    }

    public boolean updateInfo(String firstName, String lastName, long dob, String email, String password, String username) throws SQLException {
        try {
            String updateQuery = "update User set firstName = '" + firstName + "' , lastName = '" + lastName + "', dob = '" + dob + "' ,email = '" + email + "' , password = '" + password + "' where userName='" + username + "'";
            connectionManager.executeWrite(updateQuery);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
        return false;
    }
}