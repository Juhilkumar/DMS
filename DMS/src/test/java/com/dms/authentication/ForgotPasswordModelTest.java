package com.dms.authentication;

import com.dms.authentication.abstractfactory.AuthenticationAbstractFactoryTest;
import com.dms.authentication.interfaces.IForgotPasswordModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForgotPasswordModelTest {
    AuthenticationAbstractFactoryTest authenticationAbstractFactoryTest;
    IForgotPasswordModel iForgotPasswordModel;

    @BeforeEach
    void init() {
        authenticationAbstractFactoryTest = AuthenticationAbstractFactoryTest.instance();
        iForgotPasswordModel = authenticationAbstractFactoryTest.iForgotPasswordModel();
    }

    @Test
    public void resetPasswordTest() throws SQLException {
        assertEquals(true, iForgotPasswordModel.resetPassword("ashwin", "jemish@gmail.com", "honda", "password", "password"));
    }
}