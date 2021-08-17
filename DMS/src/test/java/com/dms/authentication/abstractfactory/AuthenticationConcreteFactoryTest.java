package com.dms.authentication.abstractfactory;

import com.dms.authentication.*;
import com.dms.authentication.interfaces.*;

public class AuthenticationConcreteFactoryTest extends AuthenticationAbstractFactoryTest {
    public ILoginModel createLoginModel() {
        return new LoginModel(new LoginDAOMock());
    }

    public ICaptcha createCaptchaModel() {
        return new CaptchaModel();
    }

    public ISingUpModel createSignUpModelTest() {
        return new SignUpModel(new SignUpDAOMock());
    }

    public ForgotPasswordDAOMock forgotPasswordDAOMock() {
        return new ForgotPasswordDAOMock();
    }

    public IForgotPasswordModel iForgotPasswordModel() {
        return new ForgotPasswordModel(forgotPasswordDAOMock());
    }

    public IPasswordVerify iPasswordVerify() {
        return new PasswordVerify();
    }
}