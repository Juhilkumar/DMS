package com.dms.department;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactUsController {
    @RequestMapping(value="contactus")
    public String showContactUsPage() {
        return "contactus";
    }
}