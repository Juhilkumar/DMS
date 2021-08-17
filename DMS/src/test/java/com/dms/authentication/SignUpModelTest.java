package com.dms.authentication;

import com.dms.authentication.abstractfactory.AuthenticationAbstractFactoryTest;
import com.dms.authentication.interfaces.ISingUpModel;
import com.dms.user.UserModel;
import com.dms.user.interfaces.IUserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class SignUpModelTest {
    AuthenticationAbstractFactoryTest authenticationAbstractFactoryTest;
    ISingUpModel iSingUpModel;

    @BeforeEach
    void init() {
        authenticationAbstractFactoryTest = AuthenticationAbstractFactoryTest.instance();
        iSingUpModel = authenticationAbstractFactoryTest.createSignUpModelTest();
    }

    @Test
    void saveUserTest() throws SQLException {
        IUserModel user = new UserModel();

        user.setUsername("Pratik123");
        user.setEmail("pratil@gmail.com");
        user.setFirstName("Pratik");
        user.setLastName("Zala");
        user.setDob(15 - 1 - 1999L);
        user.setSecurityAnswer("farari");
        user.setPassword("Pratik@123");
        user.setRole("student");
        Assertions.assertTrue(iSingUpModel.saveUser(user));
    }
}