package com.dms.authentication;

import com.dms.authentication.abstractfactory.AuthenticationAbstractFactory;
import com.dms.authentication.interfaces.ICaptcha;
import com.dms.authentication.interfaces.ILoginModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class LoginController {
    private static final String STUDENT_PAGE = "studentlogin";
    private static final String FACULTY_PAGE = "facultylogin";
    private static final String ADMIN_PAGE = "redirect:/admin";
    private static final String LOGGED_IN = "yes";

    AuthenticationAbstractFactory authenticationAbstractFactory = AuthenticationAbstractFactory.instance();
    ILoginModel iLoginModel = authenticationAbstractFactory.createLoginModel();
    ICaptcha iCaptcha = authenticationAbstractFactory.createCaptchaModel();

    @GetMapping(value = "/login")
    public String showLoginPage(ModelMap model) {
        String captcha = iCaptcha.generateCaptcha();
        model.addAttribute("captchainput", captcha);
        return "login";
    }

    @PostMapping(value = "/accountlogin")
    public String login(@RequestParam("UserID") String UserID, @RequestParam("password") String password, @RequestParam("captchaOutput") String captchaOutput, HttpServletRequest request) throws SQLException {
        boolean isValidCaptcha = iCaptcha.captcha(captchaOutput);
        String displayPage = iLoginModel.userValidation(UserID, password);
        if (isValidCaptcha && (StringUtils.equals(displayPage, STUDENT_PAGE) || StringUtils.equals(displayPage, FACULTY_PAGE) || StringUtils.equals(displayPage, ADMIN_PAGE))) {
            HttpSession session = request.getSession();
            session.setAttribute("username", UserID);
            session.setAttribute("loggedIn", LOGGED_IN);
            return displayPage;
        }
        return "invalidlogin";
    }
}
