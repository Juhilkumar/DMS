package com.dms.authentication;

import com.dms.authentication.interfaces.IValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinAndMaxLengthPasswordValidatorTest {
    private static final int MINIMUM_LENGTH = 6;
    private static final int MAXIMUM_LENGTH = 15;
    private static final String MIN_AND_MAX_LENGTH_ERROR = "Your password should have minimum length of " + MINIMUM_LENGTH + "end maximin length of" + MAXIMUM_LENGTH;
    IValidation minAndMaxLengthPasswordValidation;

    @BeforeEach
    public void init() {
        minAndMaxLengthPasswordValidation = new MinAndMaxLengthPasswordValidation();
    }

    @Test
    void isValidTest1() throws Exception {
        String password1 = "juhil111@2";
        String password2 = "ju";
        Assertions.assertTrue(minAndMaxLengthPasswordValidation.isValid(password1), MIN_AND_MAX_LENGTH_ERROR);
        Assertions.assertThrows(IllegalArgumentException.class, () -> minAndMaxLengthPasswordValidation.isValid(password2), MIN_AND_MAX_LENGTH_ERROR);
    }

    @Test
    void isValidTest2() throws Exception {
        String password1 = "juhil1@1$21";
        String password2 = "juhil12345566667";
        Assertions.assertTrue(minAndMaxLengthPasswordValidation.isValid(password1), MIN_AND_MAX_LENGTH_ERROR);
        Assertions.assertThrows(IllegalArgumentException.class, () -> minAndMaxLengthPasswordValidation.isValid(password2), MIN_AND_MAX_LENGTH_ERROR);
    }
}