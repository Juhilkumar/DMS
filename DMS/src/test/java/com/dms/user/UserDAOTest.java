package com.dms.user;

import com.dms.user.interfaces.IUserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserDAOTest {
    UserDAOMock userDaoMock = new UserDAOMock();

    @Test
    void getUserIdTest() {
        int userId = userDaoMock.getUserId("Juhil");
        Assertions.assertEquals(25, userId);
    }

    @Test
    void getUserListTest() {
        IUserModel user = new UserModel();
        List<IUserModel> userList = new ArrayList<>();
        user.setUsername("Pratik");
        user.setFirstName("Pratik");
        user.setRole("student");
        user.setStatus("approve");
        userList.add(user);
        Assertions.assertEquals(userList.size(), userDaoMock.getUserList().size());
    }

    @Test
    void approveUserTest() {
        String result = userDaoMock.approveUser("Parth");
        Assertions.assertEquals("Parth", result);
    }

    @Test
    void removeUserTest() {
        String result = userDaoMock.removeUser("Sahil");
        Assertions.assertEquals("Sahil", result);
    }
}