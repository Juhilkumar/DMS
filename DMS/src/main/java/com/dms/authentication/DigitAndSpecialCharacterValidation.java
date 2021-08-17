package com.dms.authentication;

import com.dms.authentication.interfaces.IValidation;

public class DigitAndSpecialCharacterValidation implements IValidation {
    private static final int MINIMUM_DIGITS = 1;
    private static final int MINIMUM_SPECIAL_CHARACTERS = 1;
    private static final String SPECIAL_CHARACTER_PATTERN = "(?=.*[~!@#$%^&*()_-]).*";
    private static final String DIGIT_ERROR = "Your password should have minimum " + MINIMUM_DIGITS + " digit";
    private static final String SPECIAL_CHARACTER_ERROR = "Your password should have minimum " + MINIMUM_SPECIAL_CHARACTERS + "special characters";

    public Boolean isValid(String password) {
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digitCount++;
            }
        }

        if (digitCount < MINIMUM_DIGITS) {
            throw new IllegalArgumentException(DIGIT_ERROR);
        } else if (password.matches(SPECIAL_CHARACTER_PATTERN) && digitCount > MINIMUM_DIGITS) {
            return true;
        } else {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_ERROR);
        }
    }
}
