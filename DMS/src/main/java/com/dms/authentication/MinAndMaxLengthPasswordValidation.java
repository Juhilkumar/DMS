package com.dms.authentication;

import com.dms.authentication.interfaces.IValidation;

public class MinAndMaxLengthPasswordValidation implements IValidation {
    private static final int MINIMUM_LENGTH = 6;
    private static final int MAXIMUM_LENGTH = 15;
    private static final String MINIMUM_LENGTH_ERROR = "Your password should have minimum length of " + MINIMUM_LENGTH;
    private static final String MAXIMUM_LENGTH_ERROR = "Your password should have maximum length of " + MAXIMUM_LENGTH;

    public Boolean isValid(String password) {
        if (password.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(MAXIMUM_LENGTH_ERROR);
        } else if (password.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException(MINIMUM_LENGTH_ERROR);
        }
        return true;
    }
}
