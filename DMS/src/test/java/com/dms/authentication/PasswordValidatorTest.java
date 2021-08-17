package com.dms.authentication;

import com.dms.authentication.interfaces.IValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PasswordValidatorTest {

    IValidation passwordValidation;

    @BeforeEach
    public void init() {
        passwordValidation = new PasswordValidator();
    }

    @Test
    void isValidTest() {
        List<IValidation> validations = new ArrayList<>();

        validations.add(new MinAndMaxLengthPasswordValidation());
        validations.add(new CasePasswordValidation());
        validations.add(new DigitAndSpecialCharacterValidation());

        Assertions.assertTrue(passwordValidation.isValid("Juhil@7734"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordValidation.isValid("ksWeW12"));
    }
}