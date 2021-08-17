package com.dms.authentication.interfaces;

import com.dms.user.interfaces.IUserModel;

import java.sql.SQLException;

public interface ISingUpModel {
    Boolean saveUser(IUserModel user) throws SQLException;
}
