package com.dms.authentication;

import com.dms.authentication.abstractfactory.AuthenticationAbstractFactory;
import com.dms.authentication.interfaces.IForgotPasswordModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;

@Controller
public class ForgotPasswordController {
    AuthenticationAbstractFactory authenticationAbstractFactory = AuthenticationAbstractFactory.instance();
    IForgotPasswordModel forgotPasswordModel = authenticationAbstractFactory.iForgotPasswordModel();

    @RequestMapping(value = "/forgotpassword")
    public String forgotPasswordPage() {
        return "forgotpassword";
    }

    @PostMapping(value="/resetPassword")
    public String resetPassword(@RequestParam("username") String userName,  @RequestParam("securityAnswer") String securityAnswer, @RequestParam("emailID") String emailID, @RequestParam("password") String password, @RequestParam("reenterPassword") String reenterPassword) throws SQLException {
        boolean passwordReset = false;
        passwordReset = forgotPasswordModel.resetPassword(userName,emailID,securityAnswer,password,reenterPassword);
        if(passwordReset) {
            return "redirect:/";
        }
        else {
            return "redirect:forgotpassword";
        }
    }
}