package com.dms.authentication.abstractfactory;

import com.dms.authentication.interfaces.ICaptcha;
import com.dms.authentication.interfaces.ILoginModel;
import com.dms.authentication.interfaces.ISingUpModel;
import com.dms.authentication.ForgotPasswordDAOMock;
import com.dms.authentication.interfaces.*;

public abstract class AuthenticationAbstractFactoryTest {
    private static AuthenticationAbstractFactoryTest uniqueInstance = null;

    public abstract ILoginModel createLoginModel();
    public abstract ICaptcha createCaptchaModel();
    public abstract ISingUpModel createSignUpModelTest();
    public abstract ForgotPasswordDAOMock forgotPasswordDAOMock();
    public abstract IForgotPasswordModel iForgotPasswordModel();
    public abstract IPasswordVerify iPasswordVerify();

    public static AuthenticationAbstractFactoryTest instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new AuthenticationConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}