package com.dms.authentication;

import com.dms.authentication.interfaces.IValidation;

public class CasePasswordValidation implements IValidation {
    private static final int MINIMUM_LOWER_CASE_CHARACTERS = 1;
    private static final int MINIMUM_UPPER_CASE_CHARACTERS = 1;
    private static final String LOWER_CASE_ERROR = "Your password should have minimum " + MINIMUM_LOWER_CASE_CHARACTERS + " lower case character";
    private static final String UPPER_CASE_ERROR = "Your password should have minimum " + MINIMUM_UPPER_CASE_CHARACTERS + " upper case character";

    public Boolean isValid(String password) {
        int lowerCaseCount = 0;
        int upperCaseCount = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                lowerCaseCount++;
            } else if (Character.isUpperCase(password.charAt(i))) {
                upperCaseCount++;
            }
        }

        if (lowerCaseCount < MINIMUM_LOWER_CASE_CHARACTERS) {
            throw new IllegalArgumentException(LOWER_CASE_ERROR);
        } else if (upperCaseCount < MINIMUM_UPPER_CASE_CHARACTERS) {
            throw new IllegalArgumentException(UPPER_CASE_ERROR);
        } else {
            return true;
        }
    }
}
