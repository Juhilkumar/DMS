package com.dms.authentication;

import com.dms.user.UserModel;
import com.dms.user.interfaces.IUserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SignUpDAOTest {

    IUserModel user;

    @BeforeEach
    void init() {
        user = new UserModel();
        user.setUsername("Pratik");
        user.setEmail("pratil@gmail.com");
        user.setFirstName("Pratik");
        user.setLastName("Zala");
        user.setDob(15 - 01 - 1999l);
        user.setSecurityAnswer("farari");
        user.setPassword("Pratik@123");
        user.setRole("student");
    }

    @Test
    void isUserValidTest() {
        SignUpDAOMock signUpMock = new SignUpDAOMock();
        Assertions.assertFalse(signUpMock.isUserValid(user));
    }

    @Test
    void insertUserTest() {
        SignUpDAOMock signUpMock = new SignUpDAOMock();
        Assertions.assertTrue(signUpMock.insertUser(user));
    }

    @Test
    void testInsertInfoInSeparateTableBasedOnUserRoleTest() {
        SignUpDAOMock signUpMock = new SignUpDAOMock();
        Assertions.assertTrue(signUpMock.insertInfoInSeparateTableBasedOnUserRole(user));
    }
}