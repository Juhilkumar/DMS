package com.dms.course;

import com.dms.course.abstractfactory.CourseAbstractFactory;
import com.dms.course.interfaces.ICourseDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    private static final String USER_LOGGEDIN="loggedIn";
    private static final String IS_USER_LOGGEDIN="yes";
    private static final String GET_USERNAME="username";
    private static final String HOME_PAGE = "homepage";
    private static final String ADD_COURSE = "addCourse";
    private static final String COURSE_ID_ALREADY_EXIST= "courseIdAlreadyExist";
    private static final String COURSE_REGISTRATION= "courseRegistration";
    private static final String COURSE_REGISTRATION_SUCCESS = "courseRegistrationSuccessful";
    private static final String COURSE_ALREADY_REGISTERED = "alreadyRegisteredCourse";
    private static final String WITHDRAW_SUCCESS = "withdrawSuccess";
    private static final String WITHDRAW_FAIL = "withdrawFail";
    private static final String ERROR_PAGE = "error";


    CourseAbstractFactory courseAbstractFactory = CourseAbstractFactory.instance();
    ICourseDAO iCourseDAO = courseAbstractFactory.createCourseDAO();


    @RequestMapping(value = "/addCourse", method = RequestMethod.GET)
    public ModelAndView courseList(ModelMap modelMap, HttpServletRequest request) throws SQLException {
        List<Course> courseList = iCourseDAO.getCourses();
        HttpSession session = request.getSession();
        ModelAndView model = new ModelAndView(ADD_COURSE);
        model.addObject("list", courseList);
        String userName = (String) session.getAttribute(GET_USERNAME);
        List<String> timetableList = new ArrayList<>();
        timetableList = iCourseDAO.retrieveTimetable(userName);
        modelMap.addAttribute("timetablelist",timetableList);
        return model;
    }

    @RequestMapping(value = "addCourse")
    public String showCourse(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute("loggedIn");
        if(StringUtils.equals(loggedIn,"yes")){
            return ADD_COURSE;
        }
        return "redirect:/";
    }

    @RequestMapping("ProcessAddCourse")
    public String addCourse(@RequestParam("courseId") int courseId, @RequestParam("courseName") String courseName, @RequestParam("facultyId") int  facultyId, @RequestParam("day") String[] days ,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTtime) throws SQLException {
        String timetable = "";
        for(int i=0;i< days.length;i++)
        {
            if(i< days.length-1)
            {
                timetable =timetable+days[i]+", ";
            }
            else{
                timetable =timetable+days[i];
            }
        }
        timetable = timetable+ " "+startTime+" to "+endTtime;
        if (iCourseDAO.isCourseIdAlreadyTaken(courseId)) {
            return COURSE_ID_ALREADY_EXIST;
        } else {
            iCourseDAO.addCourse(courseId, courseName, facultyId, timetable);
            return "redirect:/addCourse";
        }
    }

    @RequestMapping(value = "/{courseName}/removeCourse", method = RequestMethod.GET)
    public ModelAndView removeCourse(@PathVariable String courseName) throws SQLException {
        iCourseDAO.removeCourse(courseName);
        return new ModelAndView("redirect:/addCourse");
    }


    @RequestMapping(value="/courseRegistrationPage",method = RequestMethod.GET)
    public String showCourseRegistrationPage(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)){
            ArrayList<Course> coursesList = iCourseDAO.getCourses();
            model.addAttribute("courseList",coursesList);
            return COURSE_REGISTRATION;
        }
        else{
            return HOME_PAGE;
        }
    }

    @RequestMapping(value="/registerCourse/{courseId}",method = RequestMethod.GET)
    public String registerCourse(HttpServletRequest request, @PathVariable(name ="courseId") int courseId, @RequestParam("semester") int semester)
            throws Exception {

        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            boolean courseRegistered = iCourseDAO.registerCourse(courseId,userName,semester);
            if(courseRegistered) {
                return COURSE_REGISTRATION_SUCCESS;
            }
            else{
                return COURSE_ALREADY_REGISTERED;
            }
        }
        else {
            return "error";
        }
    }

    @RequestMapping(value="/withdrawCourse/{courseId}",method = RequestMethod.GET)
    public String withdrawCourse(HttpServletRequest request, @PathVariable(name ="courseId") int courseId)
            throws Exception {

        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            boolean withdrawSuccess = iCourseDAO.withdrawCourse(courseId, userName);
            if(withdrawSuccess){
                return WITHDRAW_SUCCESS;
            }
            else{
                return WITHDRAW_FAIL;
            }
        }
        else {
            return ERROR_PAGE;
        }
    }
}
