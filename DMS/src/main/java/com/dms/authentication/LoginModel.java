package com.dms.authentication;

import com.dms.authentication.interfaces.ILoginModel;
import com.dms.authentication.interfaces.IUserLogin;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.List;

public class LoginModel implements ILoginModel {
    private static final String STUDENT_ROLE = "student";
    private static final String FACULTY_ROLE = "faculty";
    private static final String ADMIN_ROLE = "admin";
    private static final String STUDENT_PAGE = "studentlogin";
    private static final String FACULTY_PAGE = "facultylogin";
    private static final String ADMIN_PAGE = "redirect:/admin";
    private static final String INVALID_PAGE = "invalidlogin";
    private static final String USER_APPROVAL = "approved";

    private final IUserLogin iUserLogin;
    String displayPage;

    public LoginModel(IUserLogin iUserLogin) {
        this.iUserLogin = iUserLogin;
    }

    public String userValidation(String userID, String password) throws SQLException {
        List userInfo = iUserLogin.userInformation(userID, password);
        if (StringUtils.equals((CharSequence) userInfo.get(0), STUDENT_ROLE) && StringUtils.equals((CharSequence) userInfo.get(1), USER_APPROVAL)) {
            displayPage = STUDENT_PAGE;
        } else if (userInfo.get(0).equals(FACULTY_ROLE) && userInfo.get(1).equals("approved")) {
            displayPage = FACULTY_PAGE;
        } else if (userInfo.get(0).equals(ADMIN_ROLE) && userInfo.get(1).equals("approved")) {
            displayPage = ADMIN_PAGE;
        } else {
            displayPage = INVALID_PAGE;
        }
        return displayPage;
    }
}


