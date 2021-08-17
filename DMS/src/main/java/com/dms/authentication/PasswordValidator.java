package com.dms.authentication;

import com.dms.authentication.interfaces.IValidation;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator implements IValidation {
    private final List<IValidation> validations = new ArrayList<>();

    public PasswordValidator() {
        validations.add(new MinAndMaxLengthPasswordValidation());
        validations.add(new CasePasswordValidation());
        validations.add(new DigitAndSpecialCharacterValidation());
    }

    public Boolean isValid(String password) {
        for (IValidation validator : validations) {
            if (Boolean.FALSE.equals(validator.isValid(password))) {
                return false;
            }
        }
        return true;
    }
}
