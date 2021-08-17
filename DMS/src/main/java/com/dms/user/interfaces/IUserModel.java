package com.dms.user.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IUserModel {
    int getUserId();

    void setUserId(int userId);

    String getUsername();

    void setUsername(String username);

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getSecurityAnswer();

    void setSecurityAnswer(String securityAnswer1);

    long getDob();

    void setDob(long dob);

    String getRole();

    void setRole(String role);

    String getStatus();

    void setStatus(String status);

    Boolean userAgeRequirement(String dateOfBirth);

    Boolean validateDOB(String dateOfBirth);

    List<IUserModel> showUserList() throws SQLException;

    String removeUser(String username) throws SQLException;

    String approveUser(String username) throws SQLException;
}
