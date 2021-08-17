package com.dms.authentication;

import com.dms.authentication.abstractfactory.AuthenticationAbstractFactory;
import com.dms.authentication.interfaces.IPasswordVerify;
import com.dms.authentication.interfaces.IValidation;
import org.apache.commons.lang3.StringUtils;

public class PasswordVerify implements IPasswordVerify {
    AuthenticationAbstractFactory authenticationAbstractFactory = AuthenticationAbstractFactory.instance();
    IValidation passwordValid = authenticationAbstractFactory.createPasswordValidator();

    public boolean passwordVerify(String password, String reenterPassword) {
        if(StringUtils.equals(password,reenterPassword) && passwordValid.isValid(password)) {
            return true;
        }
        else {
            return false;
        }
    }
}