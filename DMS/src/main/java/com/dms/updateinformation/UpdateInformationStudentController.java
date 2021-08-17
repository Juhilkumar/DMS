package com.dms.updateinformation;

import com.dms.authentication.interfaces.IPasswordVerify;
import com.dms.authentication.interfaces.IValidation;
import com.dms.updateinformation.abstractfactory.UpdateInformationAbstractFactory;
import com.dms.updateinformation.interfaces.IUpdateInformationModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UpdateInformationStudentController {
    private static final String PATTERN = "dd-MM-yyyy";

    UpdateInformationAbstractFactory updateInformationAbstractFactory = UpdateInformationAbstractFactory.instance();
    IUpdateInformationModel iUpdateInformationModel = updateInformationAbstractFactory.iUpdateInformationModel();
    IPasswordVerify passwordVerify = updateInformationAbstractFactory.passwordVerify();
    IValidation passwordValidation = updateInformationAbstractFactory.createValidation();

    @RequestMapping(value="/updateInformationStudent")
    public String showInfoPage(ModelMap model, HttpServletRequest request) throws SQLException, ParseException {
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        List<String> details = new ArrayList<>();
        if(StringUtils.equals(session.getAttribute("loggedIn").toString(),"yes")) {
            details = iUpdateInformationModel.getDetails(username);
            DateFormat formatDate = new SimpleDateFormat(PATTERN);
            long dob = Long.parseLong(details.get(2));
            Date date = new Date(dob);
            String bdate = formatDate.format(date);
            model.addAttribute("firstName",details.get(0));
            model.addAttribute("lastName",details.get(1));
            model.addAttribute("birthDate",bdate);
            model.addAttribute("email",details.get(3));
            model.addAttribute("password",details.get(4));
            return "updateInformationStudent";
        }
        else{
            return "homepage";
        }
    }

    @PostMapping("/updateinformation")
    public String updateInfo(ModelMap model, HttpServletRequest request, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("dateOfBirth") String dob, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("reenterPassword") String reenterPassword) throws Exception {
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        Date dateOfBirth = new SimpleDateFormat(PATTERN).parse(dob);
        if(passwordVerify.passwordVerify(password,reenterPassword) && passwordValidation.isValid(password)){
            iUpdateInformationModel.updateInformation(firstName,lastName,dateOfBirth.getTime(),email,password,username);
            return "redirect:updateInformationStudent";
        }
        else {
            return "redirect:studentlogin";
        }
    }
}