package com.dms.authentication;

import com.dms.authentication.abstractfactory.AuthenticationAbstractFactory;
import com.dms.authentication.interfaces.ISingUpModel;
import com.dms.authentication.interfaces.IValidation;
import com.dms.user.abstarctfactory.UserAbstractFactory;
import com.dms.user.interfaces.IUserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SignUpController {
    private static final String SIGN_UP_PAGE = "signupForm";
    private static final String SIGN_UP_SUCCESS_PAGE = "signupSuccess";
    private static final String ERROR_PAGE = "error";
    private static final String DATE_PATTERN = "dd-MM-yyyy";

    AuthenticationAbstractFactory authenticationAbstractFactory = AuthenticationAbstractFactory.instance();
    UserAbstractFactory userAbstractFactory = UserAbstractFactory.instance();
    ISingUpModel iSingUpModel = authenticationAbstractFactory.createSignUpModel();
    IValidation passwordValidation = authenticationAbstractFactory.createPasswordValidator();

    @RequestMapping(value = "/signUpForm")
    public String showForm() {
        return SIGN_UP_PAGE;
    }

    @RequestMapping(value = "/processForm")
    public String showSuccess(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("dob") String dob,
            @RequestParam("securityAnswer") String securityAnswer,
            @RequestParam("password") String password,
            @RequestParam("role") String role
    ) throws SQLException, ParseException {
        Date birthDate = new SimpleDateFormat(DATE_PATTERN).parse(dob);
        IUserModel user = userAbstractFactory.createUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDob(birthDate.getTime());
        user.setSecurityAnswer(securityAnswer);
        user.setPassword(password);
        user.setRole(role);
        if (
                Boolean.TRUE.equals(passwordValidation.isValid(password)) &&
                Boolean.TRUE.equals(user.validateDOB(dob)) &&
                Boolean.TRUE.equals(user.userAgeRequirement(dob))
        ) {
            iSingUpModel.saveUser(user);
            return SIGN_UP_SUCCESS_PAGE;
        }
        return ERROR_PAGE;
    }
}






