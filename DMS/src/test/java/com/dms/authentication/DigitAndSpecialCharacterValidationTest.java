package com.dms.authentication;

import com.dms.authentication.interfaces.IValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitAndSpecialCharacterValidationTest {
    private static final int MINIMUM_DIGITS = 1;
    private static final int MINIMUM_SPECIAL_CHARACTERS = 1;
    private static final String DIGIT_AND_SPECIAL_CHARACTER_ERROR = "Your password should have minimum " + MINIMUM_DIGITS + " digits with minimum " + MINIMUM_SPECIAL_CHARACTERS + "Special characters";
    IValidation digitAndSpecialCharacterValidation;

    @BeforeEach
    public void init() {
        digitAndSpecialCharacterValidation = new DigitAndSpecialCharacterValidation();
    }

    @Test
    void isValidTest1() throws Exception {
        String password1 = "juhil1@1";
        String password2 = "juhil";
        Assertions.assertTrue(digitAndSpecialCharacterValidation.isValid(password1), DIGIT_AND_SPECIAL_CHARACTER_ERROR);
        Assertions.assertThrows(IllegalArgumentException.class, () -> digitAndSpecialCharacterValidation.isValid(password2), DIGIT_AND_SPECIAL_CHARACTER_ERROR);
    }

    @Test
    void isValidTest2() throws Exception {
        String password1 = "part2@12";
        String password2 = "jauee";
        Assertions.assertTrue(digitAndSpecialCharacterValidation.isValid(password1), DIGIT_AND_SPECIAL_CHARACTER_ERROR);
        Assertions.assertThrows(IllegalArgumentException.class, () -> digitAndSpecialCharacterValidation.isValid(password2), DIGIT_AND_SPECIAL_CHARACTER_ERROR);
    }
}