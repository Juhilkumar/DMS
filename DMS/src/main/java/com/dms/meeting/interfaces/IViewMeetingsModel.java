package com.dms.meeting.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IViewMeetingsModel {
    Map<Integer, List> meetingsInformation(String userName, Date date) throws SQLException;
}
