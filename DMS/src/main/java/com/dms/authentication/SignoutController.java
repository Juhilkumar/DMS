package com.dms.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SignoutController {

    @RequestMapping(value = "/signOut", method = RequestMethod.GET)
    public String signout( HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("loggedIn").equals("yes")){
            session.setAttribute("loggedIn","No");
        }
        return "redirect:/login";
    }

}
