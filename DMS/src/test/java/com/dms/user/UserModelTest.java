package com.dms.user;

import com.dms.user.abstractfactory.UserAbstractFactoryTest;
import com.dms.user.interfaces.IUserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class UserModelTest {
    UserAbstractFactoryTest userAbstractFactoryTest;
    IUserModel user;

    @BeforeEach
    void init() {
        userAbstractFactoryTest = UserAbstractFactoryTest.instance();
        user = userAbstractFactoryTest.createUser();
    }

    @Test
    void getUsernameTest() {
        String username = "Parth";
        user.setUsername(username);
        Assertions.assertNotNull(user.getUsername());
        Assertions.assertEquals(username, user.getUsername());
    }

    @Test
    void setUsername() {
        String username = "Juhil";
        user.setUsername(username);
        Assertions.assertNotNull(user.getUsername());
        Assertions.assertEquals(username, user.getUsername());
    }

    @Test
    void getEmail() {
        String email = "juhil@zala.com";
        user.setEmail(email);
        Assertions.assertNotNull(user.getEmail());
        Assertions.assertEquals(email, user.getEmail());
    }

    @Test
    void setEmail() {
        String email = "juhil123@zala.com";
        user.setEmail(email);
        Assertions.assertNotNull(user.getEmail());
        Assertions.assertEquals(email, user.getEmail());
    }

    @Test
    void getPassword() {
        String password = "Juhil@7734";
        user.setPassword(password);
        Assertions.assertNotNull(user.getPassword());
        Assertions.assertEquals(password, user.getPassword());
    }

    @Test
    void setPassword() {
        String password = "Geas@sd122";
        user.setPassword(password);
        Assertions.assertNotNull(user.getPassword());
        Assertions.assertEquals(password, user.getPassword());
    }

    @Test
    void getFirstName() {
        String firstName = "Juhil";
        user.setFirstName(firstName);
        Assertions.assertNotNull(user.getFirstName());
        Assertions.assertEquals(firstName, user.getFirstName());
    }

    @Test
    void setFirstName() {
        String firstName = "jenil";
        user.setFirstName(firstName);
        Assertions.assertNotNull(user.getFirstName());
        Assertions.assertEquals(firstName, user.getFirstName());
    }

    @Test
    void getLastName() {
        String lastName = "Zalavadiya";
        user.setLastName(lastName);
        Assertions.assertNotNull(user.getLastName());
        Assertions.assertEquals(lastName, user.getLastName());
    }

    @Test
    void setLastName() {
        String lastName = "panchal";
        user.setLastName(lastName);
        Assertions.assertNotNull(user.getLastName());
        Assertions.assertEquals(lastName, user.getLastName());
    }

    @Test
    void getSecurityAnswer() {
        String securityAnswer = "honda";
        user.setSecurityAnswer(securityAnswer);
        Assertions.assertNotNull(user.getSecurityAnswer());
        Assertions.assertEquals(securityAnswer, user.getSecurityAnswer());
    }

    @Test
    void setSecurityAnswer() {
        String securityAnswer = "farari";
        user.setSecurityAnswer(securityAnswer);
        Assertions.assertNotNull(user.getSecurityAnswer());
        Assertions.assertEquals(securityAnswer, user.getSecurityAnswer());
    }

    @Test
    void getDob() {
        long date = 17 - 12 - 2001;
        user.setDob(date);
        Assertions.assertNotNull(user.getDob());
        Assertions.assertEquals(date, user.getDob());
    }

    @Test
    void setDob() {
        long date = 07 - 05 - 1999;
        user.setDob(date);
        Assertions.assertNotNull(user.getDob());
        Assertions.assertEquals(date, user.getDob());
    }

    @Test
    void getRole() {
        String role = "student";
        user.setRole(role);
        Assertions.assertNotNull(user.getRole());
        Assertions.assertEquals(role, user.getRole());
    }

    @Test
    void setRole() {
        String role = "faculty";
        user.setRole(role);
        Assertions.assertNotNull(user.getRole());
        Assertions.assertEquals(role, user.getRole());
    }

    @Test
    void getStatus() {
        String status = "pending";
        user.setStatus(status);
        Assertions.assertNotNull(user.getStatus());
        Assertions.assertEquals(status, user.getStatus());
    }

    @Test
    void setStatus() {
        String status = "approved";
        user.setStatus(status);
        Assertions.assertNotNull(user.getStatus());
        Assertions.assertEquals(status, user.getStatus());
    }

    @Test
    void userAgeRequirement() {
        Assertions.assertTrue(user.userAgeRequirement("07-05-1999"));
    }

    @Test
    void validateDOB() {
        Assertions.assertTrue(user.validateDOB("20-05-1999"));
    }

    @Test
    void showUserList() throws SQLException {
        List<IUserModel> userList = new ArrayList<>();
        user.setUsername("Pratik");
        user.setFirstName("Pratik");
        user.setRole("student");
        user.setStatus("approve");
        userList.add(user);
        List<IUserModel> expectedUserList = user.showUserList();
        Assertions.assertEquals(expectedUserList.size(), userList.size());
    }

    @Test
    void removeUser() throws SQLException {
        Assertions.assertEquals("Sahil", user.removeUser("Sahil"));
    }

    @Test
    void approveUser() throws SQLException {
        Assertions.assertEquals("Parth", user.approveUser("Parth"));
    }
}