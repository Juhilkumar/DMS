package com.dms.authentication;

import com.dms.authentication.interfaces.ISignUpDAO;
import com.dms.authentication.interfaces.ISingUpModel;
import com.dms.user.interfaces.IUserModel;

import java.sql.SQLException;

public class SignUpModel implements ISingUpModel {
    private static final String USER_ALREADY_EXIST_ERROR = "Username already exist, Please type a different username";

    private final ISignUpDAO iSignUpDAO;

    public SignUpModel(ISignUpDAO iSignUpDAO) {
        this.iSignUpDAO = iSignUpDAO;
    }

    public Boolean saveUser(IUserModel user) throws SQLException {
        boolean userAlreadyPresent = iSignUpDAO.isUserValid(user);
        if (userAlreadyPresent) {
            throw new IllegalArgumentException(USER_ALREADY_EXIST_ERROR);
        } else {
            iSignUpDAO.insertUser(user);
            iSignUpDAO.insertInfoInSeparateTableBasedOnUserRole(user);
            return true;
        }
    }
}
