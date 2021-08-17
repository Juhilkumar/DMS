package com.dms.grade;

import com.dms.grade.abstractfactory.GradeAbstractFactory;
import com.dms.grade.interfaces.IGradeHistoryModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Controller
public class GradeHistoryController {
    private static final String USER_LOGGEDIN="loggedIn";
    private static final String IS_USER_LOGGEDIN="yes";
    private static final String GET_USERNAME="username";
    GradeAbstractFactory gradeAbstractFactory = GradeAbstractFactory.instance();
    IGradeHistoryModel iGradeHistoryModel = gradeAbstractFactory.createGradeHistoryModel();

    @RequestMapping(value = "/showGrades", method = RequestMethod.GET)
    public String selectCourse(ModelMap model, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            List<String> studentCoursesList = iGradeHistoryModel.courseNamesList(userName);
            model.addAttribute("studentCoursesList", studentCoursesList);
            return "displayCourses";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/retrieveGrade", method = RequestMethod.POST)
    public String showGradeHistoryPage(ModelMap model, HttpServletRequest request, @RequestParam("selectedCourse") String selectedCourse) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            Map<Integer,String> grades = iGradeHistoryModel.calculateGrades(userName,selectedCourse);
            model.addAttribute("Studentgrades",grades);
            return "gradeHistory";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/getCgpa", method = RequestMethod.POST)
    public String displayCgpa(ModelMap model, HttpServletRequest request, @RequestParam("semester") int semester) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            double cgpa = iGradeHistoryModel.calculateCgpa(userName,semester);
            model.addAttribute("cgpa",cgpa);
            return "displayCGPA";
        }
        return "redirect:/login";
    }
}

