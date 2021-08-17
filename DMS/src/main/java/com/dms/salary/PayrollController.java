package com.dms.salary;

import com.dms.salary.abstractfactory.SalaryAbstractFactory;
import com.dms.salary.interfaces.IPayrollModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class PayrollController {
    private static final String USER_LOGGEDIN="loggedIn";
    private static final String IS_USER_LOGGEDIN="yes";
    private static final String GET_USERNAME="username";
    private static final int DEFAULT = 0;

    SalaryAbstractFactory salaryAbstractFactory = SalaryAbstractFactory.instance();
    IPayrollModel iPayRollModel = salaryAbstractFactory.createPayrollModel();
    private final String SALARY_NOT_UPDATED = "Your salary is not updated yet!";

    @RequestMapping(value = "/facultyPayroll", method = RequestMethod.GET)
    public String checkSalaryDetails(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            return "facultySalaryDetails";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/retrieveSalaryInfo", method = RequestMethod.POST)
    public String checkPayroll(Model model, @RequestParam("month") String month, @RequestParam("year") String year, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        int convertedYear = Integer.parseInt(year);
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            Map<Integer, List> salaryList = iPayRollModel.facultySalaryInfo(userName, month, convertedYear);
            if (salaryList.size() > DEFAULT) {
                model.addAttribute("salaryList", salaryList);
                return "facultyPayroll";
            }
            else {
                model.addAttribute("notUpdated",SALARY_NOT_UPDATED);
                return "facultyPayroll";
            }
        }
        return "redirect:/login";
    }
}