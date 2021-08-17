package com.dms.meeting;

import com.dms.meeting.abstractfactory.MeetingAbstractFactory;
import com.dms.meeting.interfaces.IViewMeetingsModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class ViewMeetingsController  {
    private static final String USER_LOGGEDIN="loggedIn";
    private static final String IS_USER_LOGGEDIN="yes";
    private static final String GET_USERNAME="username";

    MeetingAbstractFactory meetingAbstractFactory= MeetingAbstractFactory.instance();
    IViewMeetingsModel iViewMeetingsModel = meetingAbstractFactory.createViewMeetingsModel();
    private static final String NoMeetings = "No meetings scheduled to the date selected";

    @RequestMapping(value = "/viewMeetings",method = RequestMethod.GET)
    public String viewScheduledMeetings(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            return "verifyScheduleMeetings";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/checkScheduleOfMeetings", method = RequestMethod.POST)
    public String viewMeetingsInfo(Model model, HttpServletRequest request,@RequestParam("checkDate") Date checkDate)throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            Map<Integer, List> meetingsList= iViewMeetingsModel.meetingsInformation(userName,checkDate);
            if(meetingsList.size()>0){
                model.addAttribute("meetingsList",meetingsList);
            }
            else{
                model.addAttribute("NoMeetings",NoMeetings);
            }
            return "viewMeetings";
        }
        return "redirect:/login";

    }
}
