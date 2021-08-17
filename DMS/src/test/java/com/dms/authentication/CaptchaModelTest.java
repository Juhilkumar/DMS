package com.dms.authentication;

import com.dms.authentication.abstractfactory.AuthenticationAbstractFactoryTest;
import com.dms.authentication.interfaces.ICaptcha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaptchaModelTest {
    private static final String OPERATION1 = "+";
    private static final String OPERATION2 = "-";
    private static final String OPERATION3 = "*";
    private static final int MINIMUM_BOUND = 0;
    private static final int MAXIMUM_BOUND = 10;
    AuthenticationAbstractFactoryTest authenticationAbstractFactoryTest;
    ICaptcha iCaptcha;

    @BeforeEach
    void init() {
        authenticationAbstractFactoryTest = AuthenticationAbstractFactoryTest.instance();
        iCaptcha = authenticationAbstractFactoryTest.createCaptchaModel();
    }

    @Test
    void random1Test() {
        int random1;
        boolean validNumber;
        random1 = iCaptcha.random1();
        if (random1 >= MINIMUM_BOUND && random1 < MAXIMUM_BOUND) {
            validNumber = true;
        } else {
            validNumber = false;
        }
        Assertions.assertEquals(true, validNumber);
    }

    @Test
    void random2Test() {
        int random2;
        boolean validNumber;
        random2 = iCaptcha.random2();
        if (random2 >= MINIMUM_BOUND && random2 < MAXIMUM_BOUND) {
            validNumber = true;
        } else {
            validNumber = false;
        }
        Assertions.assertEquals(true, validNumber);
    }

    @Test
    void operationTest() {
        String operation;
        boolean validOperation;
        operation = iCaptcha.operation();
        if (operation == OPERATION1 || operation == OPERATION2 || operation == OPERATION3) {
            validOperation = true;
        } else {
            validOperation = false;
        }
        Assertions.assertEquals(true, validOperation);
    }

}