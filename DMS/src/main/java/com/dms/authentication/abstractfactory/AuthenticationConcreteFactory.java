package com.dms.authentication.abstractfactory;

import com.dms.authentication.*;
import com.dms.authentication.interfaces.*;

public class AuthenticationConcreteFactory extends AuthenticationAbstractFactory {
    public  ILoginModel createLoginModel(){
        return new LoginModel(new LoginDAO());
    }
    public ICaptcha createCaptchaModel(){
        return new CaptchaModel();
    }
    public ForgotPasswordDAO forgotPasswordDAO() {
        return new ForgotPasswordDAO();
    }
    public IForgotPasswordModel iForgotPasswordModel() {
        return new ForgotPasswordModel(forgotPasswordDAO());
    }
    public ISingUpModel createSignUpModel() {
        return new SignUpModel(new SignUpDAO());
    }
    public IValidation createPasswordValidator() {
        return new PasswordValidator();
    }
}
