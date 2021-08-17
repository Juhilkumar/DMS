package com.dms.authentication;

import com.dms.authentication.interfaces.IForgotPasswordDAO;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;

public class ForgotPasswordDAOMock implements IForgotPasswordDAO {
    private static final String USERNAME = "ashwin";
    private static final String EMAIL = "jemish@gmail.com";
    private static final String SECURITYANSWER = "honda";

    public boolean updatePassword(String username, String emailId, String securityAnswer, String password, String reenterPassword) throws SQLException {
        if (StringUtils.equals(username, USERNAME) && StringUtils.equals(emailId, EMAIL) && StringUtils.equals(securityAnswer, SECURITYANSWER)) {
            return true;
        } else {
            return false;
        }
    }
}