package com.dms.meeting.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IViewMeeting {
    Map<Integer, List> ViewMeetings(String userName, Date date) throws SQLException;
}
