package com.dms.authentication.interfaces;

import java.sql.SQLException;

public interface IForgotPasswordModel {
    boolean resetPassword(String username, String emailId, String securityAnswer, String password, String reenterPassword) throws SQLException;
}
