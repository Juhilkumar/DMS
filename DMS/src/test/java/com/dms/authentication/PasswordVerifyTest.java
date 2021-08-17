package com.dms.authentication;

import com.dms.authentication.abstractfactory.AuthenticationAbstractFactoryTest;
import com.dms.authentication.interfaces.IPasswordVerify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordVerifyTest {
    AuthenticationAbstractFactoryTest authenticationAbstractFactoryTest;
    IPasswordVerify passwordVerify;

    @BeforeEach
    void init() {
        authenticationAbstractFactoryTest = AuthenticationAbstractFactoryTest.instance();
        passwordVerify = authenticationAbstractFactoryTest.iPasswordVerify();
    }

    @Test
    public void passwordVerifyTest() {
        assertEquals(true, passwordVerify.passwordVerify("Password@123", "Password@123"));
    }
}