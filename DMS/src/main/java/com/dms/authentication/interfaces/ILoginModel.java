package com.dms.authentication.interfaces;

import java.sql.SQLException;

public interface ILoginModel {
    String userValidation(String userid, String password) throws SQLException;
}
