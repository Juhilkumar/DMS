package com.dms.department;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {
    @RequestMapping(value="/")
    public String showHomePage(){
        return "homepage";
    }
}