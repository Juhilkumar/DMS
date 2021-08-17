package com.dms.authentication.abstractfactory;

import com.dms.authentication.ForgotPasswordDAO;
import com.dms.authentication.interfaces.*;

public abstract class AuthenticationAbstractFactory {
    private static AuthenticationAbstractFactory uniqueInstance = null;

    public abstract ILoginModel createLoginModel();
    public abstract ICaptcha createCaptchaModel();
    public abstract ForgotPasswordDAO forgotPasswordDAO();
    public abstract IForgotPasswordModel iForgotPasswordModel();
    public abstract ISingUpModel createSignUpModel();
    public abstract IValidation createPasswordValidator();

    public static AuthenticationAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new AuthenticationConcreteFactory();
        }
        return uniqueInstance;
    }
}
