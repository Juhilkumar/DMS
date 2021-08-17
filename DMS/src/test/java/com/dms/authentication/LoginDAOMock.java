package com.dms.authentication;

import com.dms.authentication.interfaces.IUserLogin;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LoginDAOMock implements IUserLogin {
    private static final String USER_NAME = "bhargav";
    private static final String PASSWORD = "bhargav@123";
    private static final String USER_ROLE = "student";
    private static final String USER_APPROVAL_STATUS = "approved";
    private static final String INVALID_ROLE = "invalidRole";
    private static final String DEFAULT_STATUS = "statusNotApproved";

    public List userInformation(String id, String password) {
        List userInfo = new ArrayList();
        if (StringUtils.equals(id, USER_NAME) && StringUtils.equals(password, PASSWORD)) {
            userInfo.add(USER_ROLE);
            userInfo.add(USER_APPROVAL_STATUS);
            return userInfo;
        } else {
            userInfo.add(INVALID_ROLE);
            userInfo.add(DEFAULT_STATUS);
            return userInfo;
        }
    }
}
