package com.dms.authentication;

import com.dms.authentication.interfaces.IForgotPasswordDAO;
import com.dms.authentication.interfaces.IForgotPasswordModel;
import java.sql.SQLException;

public class ForgotPasswordModel implements IForgotPasswordModel {
    private final IForgotPasswordDAO iForgotPasswordDAO;

    public ForgotPasswordModel(IForgotPasswordDAO iForgotPasswordDao) {
        this.iForgotPasswordDAO = iForgotPasswordDao;
    }

    public boolean resetPassword(String username, String emailId, String securityAnswer, String password, String reenterPassword) throws SQLException {
        boolean result =iForgotPasswordDAO.updatePassword(username,emailId,securityAnswer,password,reenterPassword);
        return result;
    }
}