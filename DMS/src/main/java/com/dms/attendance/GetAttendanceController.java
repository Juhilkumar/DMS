package com.dms.attendance;

import com.dms.attendance.abstractfactory.AttendanceAbstractFactory;
import com.dms.attendance.interfaces.IGetAttendanceModel;
import com.dms.attendance.interfaces.IGetCourseModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetAttendanceController {
    AttendanceAbstractFactory attendanceAbstractFactory = AttendanceAbstractFactory.instance();
    IGetCourseModel getCourseModel = attendanceAbstractFactory.iGetCourseModel();
    IGetAttendanceModel getAttendanceModel = attendanceAbstractFactory.iGetAttendanceModel();
    private static final String DEFAULT = "classes did not start yet";
    private static final int MIN_ATTENDANCE = 0;

    @RequestMapping(value = "/getattendance")
    public String getAttendancePage(ModelMap model, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        if(StringUtils.equals(session.getAttribute("loggedIn").toString(),"yes")) {
            String userName = session.getAttribute("username").toString();
            List<Integer> courseID = new ArrayList<>();
            courseID = getCourseModel.getCourseID(userName);
            model.addAttribute("courseID",courseID);
            return "getattendance";
        }
        else{
            return "homepage";
        }
    }

    @PostMapping(value = "/retrieveattendance")
    public String retrievingAttendance(ModelMap model, HttpServletRequest request, @RequestParam("course_ID") int courseId, RedirectAttributes redirectAttributes) throws SQLException {
        HttpSession session = request.getSession();
        String userName = session.getAttribute("username").toString();
        int attendance = getAttendanceModel.retrievingAttendance(userName,courseId);
        if(attendance < MIN_ATTENDANCE) {
            redirectAttributes.addFlashAttribute("attendance",DEFAULT);
        }
        else {
            redirectAttributes.addFlashAttribute("attendance",attendance);
        }
        return "redirect:getattendance";
    }
}