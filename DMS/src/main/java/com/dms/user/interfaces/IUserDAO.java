package com.dms.user.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    List<IUserModel> getUserList() throws SQLException;

    String removeUser(String username) throws SQLException;

    String approveUser(String username) throws SQLException;

    int getUserId(String username) throws SQLException;

    String getUserEmail(int userId) throws SQLException;
}
