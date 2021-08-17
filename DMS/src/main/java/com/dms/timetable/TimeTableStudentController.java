package com.dms.timetable;

import com.dms.timetable.abstractfactory.TimeTableAbstractFactory;
import com.dms.timetable.interfaces.ITimeTableStudentModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

@Controller
public class TimeTableStudentController {
        TimeTableAbstractFactory timeTableAbstractFactory = TimeTableAbstractFactory.instance();
        ITimeTableStudentModel timeTableStudentModel = timeTableAbstractFactory.iTimeTableStudentModel();

        @RequestMapping(value = "/timetableStudent")
        public String showTimeTableStudentPage(ModelMap model, HttpServletRequest request) throws SQLException {
            HttpSession session = request.getSession();
            if (StringUtils.equals(session.getAttribute("loggedIn").toString(),"yes")) {
                String userName = session.getAttribute("username").toString();
                Map<Integer,String> timetable = timeTableStudentModel.getTimetable(userName);
                model.addAttribute("timetable",timetable);
                return "timetableStudent";
            } else {
                return "homepage";
            }
        }
}