package com.dms.updateinformation.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IUpdateInformationModel {
    List<String> getDetails(String username) throws SQLException;
    boolean updateInformation(String firstName, String lastName, long dob, String email, String password, String username) throws SQLException;
}