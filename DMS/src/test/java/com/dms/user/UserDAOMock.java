package com.dms.user;

import com.dms.user.interfaces.IUserModel;
import com.dms.user.interfaces.IUserDAO;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOMock implements IUserDAO {

    IUserModel user = new UserModel();

    public List<IUserModel> getUserList() {
        IUserModel user = new UserModel();
        List<IUserModel> userList = new ArrayList<>();
        user.setUsername("Pratik");
        user.setFirstName("Pratik");
        user.setRole("student");
        user.setStatus("approve");
        userList.add(user);
        return userList;
    }

    public String removeUser(String username) {
        user.setUsername("Sahil");
        if (StringUtils.equals(user.getUsername(), "Sahil")) {
            return user.getUsername();
        }
        return null;
    }

    public String approveUser(String username) {
        user.setUsername("Parth");
        if (StringUtils.equals(user.getUsername(), "Parth")) {
            return user.getUsername();
        }
        return null;
    }

    public int getUserId(String username) {
        user.setUsername("Juhil");
        if (StringUtils.equals(user.getUsername(), "Juhil")) {
            return 25;
        }
        return 0;
    }

    public String getUserEmail(int userId) throws SQLException {
        user.setUserId(1);
        user.setEmail("ZalavadiyaJuhil@gmail.com");
        if (user.getUserId() == 1) {
            return user.getEmail();
        }
        return null;
    }
}
