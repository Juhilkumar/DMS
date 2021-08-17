package com.dms.meeting;

import com.dms.meeting.interfaces.IViewMeeting;
import org.apache.commons.lang3.StringUtils;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ViewMeetingsDAOMock implements IViewMeeting {
    private static final String USER_NAME ="bhargav";
    private static final int FACULTY_ID =10000;
    private static final int DATE =2021 - 03 - 24;
    private static final String SLOT ="3:00 PM";
    private static final int STUDENT_ID =11111;
    private static final int LIST_KEY =1;
    private static final String NO_MEETINGS ="No Meetings";

    public Map<Integer, List> ViewMeetings(String userName, Date date) {
        Map<Integer, List> meetingsList = new LinkedHashMap<Integer, List>();
        List meetings = new ArrayList();
        if (StringUtils.equals(userName,USER_NAME)) {
            meetings.add(FACULTY_ID);
            meetings.add(DATE);
            meetings.add(SLOT);
            meetings.add(STUDENT_ID);
            meetingsList.put(LIST_KEY, meetings);
            return meetingsList;
        } else {
            meetings.add(NO_MEETINGS);
            meetingsList.put(LIST_KEY,meetings);
            return meetingsList;
        }
    }
}
