package com.dms.authentication;

import com.dms.authentication.abstractfactory.AuthenticationAbstractFactoryTest;
import com.dms.authentication.interfaces.ILoginModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class LoginModelTest {
    private static final String STUDENT_PAGE = "studentlogin";
    private static final String INVALID_PAGE = "invalidlogin";
    ILoginModel iLoginModel;
    AuthenticationAbstractFactoryTest authenticationAbstractFactoryTest;

    @BeforeEach
    void init() {
        authenticationAbstractFactoryTest = AuthenticationAbstractFactoryTest.instance();
        iLoginModel = authenticationAbstractFactoryTest.createLoginModel();
    }

    @Test
    void userValidationTest() {
        assertAll(
                () -> Assertions.assertEquals(STUDENT_PAGE, iLoginModel.userValidation("bhargav", "bhargav@123")),
                () -> Assertions.assertEquals(INVALID_PAGE, iLoginModel.userValidation("bhargav1", "bhargav@123"))
        );
    }
}