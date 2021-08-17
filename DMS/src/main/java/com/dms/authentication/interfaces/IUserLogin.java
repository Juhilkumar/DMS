package com.dms.authentication.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IUserLogin {
    List userInformation(String id, String password) throws SQLException;
}
