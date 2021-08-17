package com.dms.classroom;

import com.dms.classroom.abstractfactory.ClassroomAbstractFactory;
import com.dms.classroom.interfaces.IClassroomModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;


@Controller
public class ClassroomController {

    private static final String USER_LOGGEDIN="loggedIn";
    private static final String IS_USER_LOGGEDIN="yes";
    private static final String GET_USERNAME="username";
    private static final String CLASSROOM = "classroom";
    private static final String HOME_PAGE = "homepage";
    private static final String SHOW_CLASSROOM = "showClassroom";
    private static final String CLASSROOM_SCHEDULE_SUCCESS = "classroomScheduleSuccess";
    private static final String CLASSROOM_SCHEDULE_FAIL = "classroomScheduleFail";



    ClassroomAbstractFactory classroomAbstractFactory = ClassroomAbstractFactory.instance();
    IClassroomModel iClassroomModel = classroomAbstractFactory.createClassroomModel();

    @RequestMapping(value = "/classroom", method = RequestMethod.GET)
    public String showClassroomSchedulePage( HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)){
            return CLASSROOM;
        } else {
            return HOME_PAGE;
        }
    }

    @RequestMapping(value = "/showClassroomSchedule", method = RequestMethod.GET)
    public String showClassroom(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            List<ClassroomModel> classroomSchedule = iClassroomModel.showClassroomSchedule(userName);
            model.addAttribute("classroomSchedule", classroomSchedule);
            return SHOW_CLASSROOM;
        } else {
            return HOME_PAGE;
        }
    }

    @RequestMapping(value = "/postClassroomSchedule")
    public String postClassroomSchedule(@RequestParam("courseId") int courseId,
                                        @RequestParam("classTopic") String classTopic,
                                        @RequestParam("scheduleDate") Date scheduleDate,
                                        @RequestParam("startTime") String startTime,
                                        @RequestParam("endTime") String endTime, HttpServletRequest request) throws Exception {
        boolean classroomFlag;
        HttpSession session = request.getSession();

        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            classroomFlag = iClassroomModel.postClassroomSchedule(userName, courseId, classTopic, scheduleDate, startTime, endTime);

            if (classroomFlag) {
                return CLASSROOM_SCHEDULE_SUCCESS;
            } else {
                return CLASSROOM_SCHEDULE_FAIL;
            }

        } else {
            return HOME_PAGE;
        }
    }
}
