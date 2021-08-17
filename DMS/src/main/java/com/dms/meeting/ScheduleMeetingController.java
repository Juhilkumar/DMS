package com.dms.meeting;

import com.dms.meeting.abstractfactory.MeetingAbstractFactory;
import com.dms.meeting.interfaces.IScheduleMeetingModel;
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
public class ScheduleMeetingController {
    private static final String USER_LOGGEDIN="loggedIn";
    private static final String IS_USER_LOGGEDIN="yes";
    private static final String GET_USERNAME="username";
    private static final String slotBookingRejected = "selected slot is unavailable.please try another slot.";
    private static final String slotBookingAccepted = "Slot booked succesfully.";

    MeetingAbstractFactory meetingAbstractFactory = MeetingAbstractFactory.instance();
    IScheduleMeetingModel iScheduleMeetingModel = meetingAbstractFactory.createScheduleMeetingModel();


    @RequestMapping(value = "/scheduleMeeting", method = RequestMethod.GET)
    public String getfacultyNames(Model model, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            Map<Integer, List> detailsList = iScheduleMeetingModel.facultyNamesList(userName);
            model.addAttribute("detailsList",detailsList);
            return "facultyMeetingDetails";
        }
        return "redirect:/login";

    }

    @RequestMapping(value = "/CheckSlotAvailabilty", method = RequestMethod.POST)
    public String checkAvailabiltyOFSlot(Model model, @RequestParam("facultyID") int facultyID,
                                         @RequestParam("appointmentDate") Date appointmentDate,
                                         @RequestParam("slot") String slot,HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN),IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            if(iScheduleMeetingModel.validateSlots(facultyID, appointmentDate, slot, userName)){
                model.addAttribute("bookingStatus",slotBookingAccepted);
            }
            else{
                model.addAttribute("bookingStatus",slotBookingRejected);
            }
            return "scheduleMeeting";
        }
    return "redirect:/login";
    }
}
