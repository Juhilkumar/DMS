package com.dms.attendance;

import com.dms.attendance.abstractfactory.AttendanceAbstractFactory;
import com.dms.attendance.interfaces.IPostAttendanceModel;
import com.dms.attendance.interfaces.IPostCourseModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostAttendanceController {
    AttendanceAbstractFactory attendanceAbstractFactory = AttendanceAbstractFactory.instance();
    IPostCourseModel postCourseModel = attendanceAbstractFactory.iPostCourseModel();
    IPostAttendanceModel postAttendanceModel = attendanceAbstractFactory.iPostAttendanceModel();

    @RequestMapping(value = "/postAttendance")
    public String postAttendancePage(ModelMap model, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        if(StringUtils.equals(session.getAttribute("loggedIn").toString(),"yes")) {
            String username = session.getAttribute("username").toString();
            List<Integer> courseID = new ArrayList<>();
            courseID = postCourseModel.getCourseIDForFaculty(username);
            model.addAttribute("courseID",courseID);
            return "postattendance";
        }
        else{
            return "redirect:homepage";
        }
    }

    @PostMapping(value = "/setattendance")
    public String Postattendance(ModelMap model, HttpServletRequest request, @RequestParam("course_ID") int courseId,@RequestParam("student_Id") int studentId,@RequestParam("attendance_status") String attendance_state) throws SQLException {
        HttpSession session = request.getSession();
        if(StringUtils.equals(session.getAttribute("loggedIn").toString(),"yes")) {
            postAttendanceModel.postAttendance(studentId,courseId,attendance_state);
            return "redirect:postAttendance";
        }
        else{
            return "redirect:homepage";
        }
    }
}