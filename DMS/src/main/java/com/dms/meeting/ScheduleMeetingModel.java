package com.dms.meeting;

import com.dms.meeting.interfaces.IScheduleMeeting;
import com.dms.meeting.interfaces.IScheduleMeetingModel;
import com.dms.notification.interfaces.ISendEmail;
import com.dms.notification.SendEmail;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ScheduleMeetingModel implements IScheduleMeetingModel {
    private static final int DEFAULT = 0;

    IScheduleMeeting iScheduleMeeting;
    private final String mailSubject = "Meeting Scheduled";

    public ScheduleMeetingModel(IScheduleMeeting iScheduleMeeting) {
        this.iScheduleMeeting = iScheduleMeeting;
    }

    public Map<Integer, List> facultyNamesList(String userName) throws SQLException {
        Map<Integer, List> facultyDetails = iScheduleMeeting.facultyDetails(userName);
        return facultyDetails;
    }

    public boolean validateSlots(int facultyID, Date date, String slot, String userName) throws SQLException {
        boolean isSlotConfirmed = false;
        int studentID = iScheduleMeeting.getStudentID(userName);
        Date today = new Date(System.currentTimeMillis());
        if (date.compareTo(today) >= DEFAULT && iScheduleMeeting.checkSlots(facultyID,date,slot)) {
            isSlotConfirmed = iScheduleMeeting.bookSlot(facultyID,date,slot,studentID);
        }
        if (isSlotConfirmed) {
            String facultyMailID = iScheduleMeeting.getFacultyMail(facultyID);
            ISendEmail sendEmailNotification = new SendEmail();
            String mailBody = "meeting is scheduled by studentID:" + studentID + " , Date:" + date + " Slot:" + slot + ".";
            String[] mailID = {facultyMailID};
            boolean mailSent = sendEmailNotification.sendMailNotification(mailID, mailSubject, mailBody);
        }
        return isSlotConfirmed;
    }
}
