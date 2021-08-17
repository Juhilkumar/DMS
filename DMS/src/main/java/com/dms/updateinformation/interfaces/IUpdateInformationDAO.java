package com.dms.updateinformation.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IUpdateInformationDAO {
    List<String> getInfo(String userName) throws SQLException;
    boolean updateInfo(String firstName, String lastName, long dob, String email, String password, String username) throws SQLException;
}