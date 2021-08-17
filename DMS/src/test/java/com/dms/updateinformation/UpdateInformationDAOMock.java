package com.dms.updateinformation;

import com.dms.updateinformation.interfaces.IUpdateInformationDAO;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class UpdateInformationDAOMock implements IUpdateInformationDAO {
    private static final String FIRSTNAME = "Parth";
    private static final String LASTNAME = "last";
    private static final long DOB = 16-03-1995;
    private static final String EMAIL = "Parth@gmail.com";
    private static final String PASSWORD = "Parth@123";
    private static final String USERNAME = "Parth";

    public List<String> getInfo(String userName) {
        List<String> info = new ArrayList<>();
        if(StringUtils.equals(userName,USERNAME)){
            info.add(FIRSTNAME);
            info.add(LASTNAME);
        }
        return info;
    }

    public boolean updateInfo(String firstName, String lastName, long dob, String email, String password, String username) {
        return StringUtils.equals(firstName,FIRSTNAME) && StringUtils.equals(lastName,LASTNAME) && dob == DOB && StringUtils.equals(email,EMAIL) && StringUtils.equals(password,PASSWORD) && StringUtils.equals(username,USERNAME);
    }
}