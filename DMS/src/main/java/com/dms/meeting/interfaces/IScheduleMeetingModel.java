package com.dms.meeting.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IScheduleMeetingModel {
    Map<Integer, List> facultyNamesList(String userName) throws SQLException;
    boolean validateSlots(int facultyID, Date date, String slot, String userName) throws SQLException;
}
