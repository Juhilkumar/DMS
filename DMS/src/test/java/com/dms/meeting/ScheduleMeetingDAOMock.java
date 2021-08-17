package com.dms.meeting;

import com.dms.meeting.interfaces.IScheduleMeeting;
import org.apache.commons.lang3.StringUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleMeetingDAOMock implements IScheduleMeeting {
    private static final String USER_NAME ="bhargav";
    private static final int COURSE_ID = 5308;
    private static final int FACULTY_ID = 10000;
    private static final String SLOT ="3:00 PM";
    private static final String MAIL ="sr995902@dal.ca";
    private static final int STUDENT_ID =11111;
    private static final int DEFAULT_ID =00000;
    private static final String COURSE_NAME ="Advanced Software Development Topics";
    private static final int LIST_KEY =1;

    public Map<Integer, List> facultyDetails(String userName){
        Map<Integer,List> facultyDetails = new HashMap<>();
        List courseInfo = new ArrayList<>();
        if(StringUtils.equals(userName,USER_NAME)){
            courseInfo.add(COURSE_ID);
            courseInfo.add(COURSE_NAME);
            courseInfo.add(FACULTY_ID);
            facultyDetails.put(LIST_KEY, courseInfo);
        }
        facultyDetails.put(LIST_KEY,courseInfo);
        return facultyDetails;
    }

    public int getStudentID(String userName){
        if (StringUtils.equals(userName,USER_NAME)) {
            int studentID = STUDENT_ID;
            return studentID;
        }
        else {
            int defaultID = DEFAULT_ID;
            return defaultID;
        }
    }

    public boolean checkSlots(int facultyID, Date date, String slot){
        Date today = new Date(System.currentTimeMillis());
        boolean slotAvailable = false;
        if (facultyID == FACULTY_ID && StringUtils.equals(slot,SLOT)) {
            slotAvailable = true;
            return slotAvailable;
        }
        else {
            return slotAvailable;
        }
    }

    public boolean bookSlot(int facultyID, Date date, String slot, int studentID){
        Date today = new Date(System.currentTimeMillis());
        boolean slotBooked = false;
        if ((facultyID == FACULTY_ID && StringUtils.equals(slot,SLOT) && studentID == STUDENT_ID)){
            slotBooked = true;
            return slotBooked;
        }
        else{
            return slotBooked;
        }
}


    public String getFacultyMail(int facultyID){
        String mail="";
        if (facultyID == FACULTY_ID){
            mail = MAIL;
        }
        return mail;
    }
}
