package com.dms.grade;

import com.dms.grade.abstractfactory.GradeAbstractFactory;
import com.dms.grade.interfaces.IPostGradesModel;
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
public class PostGradesController {
    private static final String USER_LOGGEDIN="loggedIn";
    private static final String IS_USER_LOGGEDIN="yes";
    private static final String GET_USERNAME="username";
    private static final String gradeUpdateSuccessfull = "grade updated succesfully.";
    private static final String gradeUpdateFailed = "grade is not updated. please enter marks between 0 to 100 and try again!";

    GradeAbstractFactory gradeAbstractFactory = GradeAbstractFactory.instance();
    IPostGradesModel iPostGradesModel = gradeAbstractFactory.createPostGradesModel();
    List<String> courseNames ;

    @RequestMapping(value = "/showCourses", method = RequestMethod.GET)
    public String showCourseNames(Model model, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            List<String> courseNames = iPostGradesModel.courseNamesList(userName);
            this.courseNames =  iPostGradesModel.courseNamesList(userName);
            model.addAttribute("courseNames", courseNames);
            return "FacultyCoursesList";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/studentRecords", method = RequestMethod.POST)
    public String studentRecords(Model model, HttpServletRequest request, @RequestParam("courseName") String courseName) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            Map<Integer, List<Integer>> StudentNames = iPostGradesModel.getStudentDetails(userName, courseName);
            model.addAttribute("Studentdetails", StudentNames);
            return "PostGradesToStudents";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/postGradesToStudents", method = RequestMethod.POST)
    public String postGradesToStudents(Model model, HttpServletRequest request, @RequestParam("studentGrade") int studentGrade,
                                       @RequestParam("studentId") int studentId, @RequestParam("courseId") int courseId) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            boolean updateValid = iPostGradesModel.postGrades(studentGrade, studentId, courseId);
            if (updateValid){
                model.addAttribute("gradeUpdated",gradeUpdateSuccessfull);
            }
            else{
                model.addAttribute("gradeUpdated",gradeUpdateFailed);
            }
            return "gradeUpdateSuccess";
        }
        return "redirect:/login";
    }
}
