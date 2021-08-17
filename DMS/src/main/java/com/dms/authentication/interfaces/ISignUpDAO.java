package com.dms.authentication.interfaces;

import com.dms.user.interfaces.IUserModel;

import java.sql.SQLException;

public interface ISignUpDAO {
    Boolean isUserValid(IUserModel user) throws SQLException;

    Boolean insertUser(IUserModel user) throws SQLException;

    Boolean insertInfoInSeparateTableBasedOnUserRole(IUserModel user) throws SQLException;
}
