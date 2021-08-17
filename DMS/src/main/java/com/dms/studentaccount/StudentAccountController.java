package com.dms.studentaccount;

import com.dms.studentaccount.abstractfactory.StudentAccountAbstractFactory;
import com.dms.studentaccount.interfaces.IStudentAccountDAO;
import com.dms.studentaccount.interfaces.IStudentAccountModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class StudentAccountController {

    private static final String USER_LOGGEDIN = "loggedIn";
    private static final String IS_USER_LOGGEDIN = "yes";
    private static final String GET_USERNAME = "username";
    private static final String HOME_PAGE = "homepage";
    private static final String STUDENT_ACCOUNT_PAGE = "studentAccount";

    StudentAccountAbstractFactory studentAccountAbstractFactory = StudentAccountAbstractFactory.instance();
    IStudentAccountModel iStudentAccountModel = studentAccountAbstractFactory.createStudentAccountModel();
    IStudentAccountDAO iStudentAccountDAO = studentAccountAbstractFactory.createStudentAccountDAO();

    @RequestMapping(value = "/studentAccount", method = RequestMethod.GET)
    public String showStudentAccountPage(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN), IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            StudentAccountDAO studentAccountDAO = new StudentAccountDAO();
            iStudentAccountModel = iStudentAccountDAO.getStudentAccountDetails(userName);
            model.addAttribute("studentAccount", iStudentAccountModel);
            return STUDENT_ACCOUNT_PAGE;
        } else {
            return HOME_PAGE;
        }

    }
}
