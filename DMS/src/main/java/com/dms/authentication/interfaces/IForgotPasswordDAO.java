package com.dms.authentication.interfaces;

import java.sql.SQLException;

public interface IForgotPasswordDAO {
    boolean updatePassword(String username, String emailId, String securityAnswer,String password, String reenterPassword) throws SQLException;
}
