package com.dms.user;

import com.dms.user.interfaces.IUserModel;
import com.dms.user.interfaces.IUserDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserModel implements IUserModel {
    private static final int MINIMUM_AGE_REQUIRED_FOR_SIGN_UP = 18;
    private static final String DATE_PATTERN = "\\d{2}-\\d{2}-\\d{4}";
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final String EMAIL_PATTERN = "^[0-9a-zA-Z+_.-]+@+[0-9a-zA-Z.-]+[.]+[a-zA-Z]";
    private static final String USER_AGE_ERROR = "Your age should be greater than" + MINIMUM_AGE_REQUIRED_FOR_SIGN_UP + "years for signup";
    private static final String DATE_ERROR = "Enter a valid Date of Birth in dd-MM-yyyy format";
    private static final String EMAIL_ERROR = "Enter a valid email address";

    IUserDAO iUserDAO;

    private int userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private long dob;
    private String securityAnswer;
    private String password;
    private String role;
    private String status;

    public UserModel() {

    }

    public UserModel(IUserDAO iUserDAO) {
        this.iUserDAO = iUserDAO;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean userAgeRequirement(String dateOfBirth) {
        Date birthDate;
        try {
            birthDate = new SimpleDateFormat(DATE_FORMAT).parse(dateOfBirth);
            long ageInMillis = new Date().getTime() - birthDate.getTime();
            int years = (int) (TimeUnit.MILLISECONDS.toDays(ageInMillis) / 365);
            if (years < MINIMUM_AGE_REQUIRED_FOR_SIGN_UP) {
                throw new IllegalArgumentException(USER_AGE_ERROR);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean validateDOB(String dateOfBirth) {
        if (dateOfBirth.matches(DATE_PATTERN)) {
            return true;
        }
        throw new IllegalArgumentException(DATE_ERROR);
    }

    public List<IUserModel> showUserList() throws SQLException {
        return iUserDAO.getUserList();
    }

    public String removeUser(String username) throws SQLException {
        return iUserDAO.removeUser(username);
    }

    public String approveUser(String username) throws SQLException {
        return iUserDAO.approveUser(username);
    }
}



