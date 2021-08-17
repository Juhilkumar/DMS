package com.dms.authentication;

import com.dms.authentication.interfaces.ISignUpDAO;
import com.dms.user.interfaces.IUserModel;
import org.apache.commons.lang3.StringUtils;

public class SignUpDAOMock implements ISignUpDAO {
    private static final String USER_NAME = "Pratik";
    private static final String EMAIL = "pratil@gmail.com";
    private static final String FIRST_NAME = "Pratik";
    private static final String LAST_NAME = "Zala";
    private static final Long DATE_OF_BIRTH = 15 - 1 - 1999L;
    private static final String PASSWORD = "Pratik@123";
    private static final String STUDENT_ROLE = "student";
    private static final String FACULTY_ROLE = "faculty";
    private static final String SECURITY_ANSWER = "farari";

    public Boolean isUserValid(IUserModel user) {
        user.setUsername("Pratik");
        String username = user.getUsername();
        if (StringUtils.equals(username, USER_NAME)) {
            return false;
        }
        return true;
    }

    public Boolean insertUser(IUserModel user) {
        user.setUsername("Pratik");
        user.setEmail("pratil@gmail.com");
        user.setFirstName("Pratik");
        user.setLastName("Zala");
        user.setDob(15 - 1 - 1999L);
        user.setSecurityAnswer("farari");
        user.setPassword("Pratik@123");
        user.setRole("student");
        if (StringUtils.equals(user.getUsername(), USER_NAME) &&
                StringUtils.equals(user.getEmail(), EMAIL) &&
                StringUtils.equals(user.getFirstName(), FIRST_NAME) &&
                StringUtils.equals(user.getLastName(), LAST_NAME) &&
                DATE_OF_BIRTH.equals(user.getDob()) &&
                StringUtils.equals(user.getSecurityAnswer(), SECURITY_ANSWER) &&
                StringUtils.equals(user.getPassword(), PASSWORD) &&
                StringUtils.equals(user.getRole(), STUDENT_ROLE)
        ) {
            return true;
        }
        return false;
    }

    public Boolean insertInfoInSeparateTableBasedOnUserRole(IUserModel user) {
        if (StringUtils.equals(user.getRole(), STUDENT_ROLE) || StringUtils.equals(user.getRole(), FACULTY_ROLE)) {
            return true;
        }
        return false;
    }
}
