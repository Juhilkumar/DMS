package com.dms.meeting;

import com.dms.meeting.interfaces.IViewMeeting;
import com.dms.meeting.interfaces.IViewMeetingsModel;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ViewMeetingsModel implements IViewMeetingsModel {
    private final IViewMeeting iViewMeeting;
    public ViewMeetingsModel(IViewMeeting iViewMeeting) {
        this.iViewMeeting = iViewMeeting;
    }

    public Map<Integer, List> meetingsInformation(String userName, Date date) throws SQLException {
        Map<Integer,List> meetingsList = iViewMeeting.ViewMeetings(userName,date);
        return meetingsList;
    }
}
