package com.dms.authentication;

import com.dms.authentication.interfaces.IValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CasePasswordValidatorTest {
    private static final int MINIMUM_LOWER_CASE_CHARACTERS = 1;
    private static final int MINIMUM_UPPER_CASE_CHARACTERS = 1;
    private static final String CASE_VALIDATION_ERROR = "Password must have minimum " + MINIMUM_LOWER_CASE_CHARACTERS + " lower case and " + MINIMUM_UPPER_CASE_CHARACTERS + " upper case characters ";
    IValidation casePasswordValidation;

    @BeforeEach
    public void init() {
        casePasswordValidation = new CasePasswordValidation();
    }

    @Test
    void isValidTest1() throws Exception {
        String password1 = "Juhil1";
        String password2 = "123";
        Assertions.assertTrue(casePasswordValidation.isValid(password1), CASE_VALIDATION_ERROR);
        Assertions.assertThrows(IllegalArgumentException.class, () -> casePasswordValidation.isValid(password2), CASE_VALIDATION_ERROR);
    }

    @Test
    void isValidTest2() throws Exception {
        String password1 = "Parth45";
        String password2 = "J123";
        Assertions.assertTrue(casePasswordValidation.isValid(password1), CASE_VALIDATION_ERROR);
        Assertions.assertThrows(IllegalArgumentException.class, () -> casePasswordValidation.isValid(password2), CASE_VALIDATION_ERROR);
    }
}