package com.dms.salary;

import com.dms.salary.abstractfactory.SalaryAbstractFactory;
import com.dms.salary.interfaces.IFacultySalaryModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

@Controller
public class FacultySalariesController {
    private static final String USER_LOGGEDIN="loggedIn";
    private static final String IS_USER_LOGGEDIN="yes";
    private static final String SALARY_GENERATION_SUCESSFULL = "Salary succesfully generated.";
    private static final String SALARY_GENERATION_FAILED = "Salary generation failed. Please try agian!";

    SalaryAbstractFactory salaryAbstractFactory = SalaryAbstractFactory.instance();
    IFacultySalaryModel iFacultySalaryModel = salaryAbstractFactory.createFacultySalaryModel();

    @RequestMapping(value = "/facultySalary", method = RequestMethod.GET)
    public String facultyPayrollDetails(Model model, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            Map<Integer, String> facultyDetails = iFacultySalaryModel.facultyDetails();
            model.addAttribute("facultyDetails", facultyDetails);
            return "facultySalary";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/updateFacultySalary", method = RequestMethod.POST)
    public String updateFacultySalary(Model model, HttpServletRequest request, @RequestParam("facultyId") int facultyId,
                                      @RequestParam("salary") int salary, @RequestParam("month") int month,
                                      @RequestParam("year") int year) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            if (iFacultySalaryModel.updateSalary(facultyId, salary, month, year)) {
                model.addAttribute("salaryGenerated",SALARY_GENERATION_SUCESSFULL );
            } else {
                model.addAttribute("salaryGenerated", SALARY_GENERATION_FAILED);
            }
            return "salaryGenerationSuccessfull";
        }
        return "redirect:/login";
    }
}
