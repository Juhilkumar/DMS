package com.dms.meeting;

import com.dms.meeting.interfaces.IViewMeeting;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ViewMeetingsDAO implements IViewMeeting {
    private static final int VALUE =1;
    int keyOfMap = 1;
    private final ISqlConnection connectionManager;
    public ViewMeetingsDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public Map<Integer, List> ViewMeetings(String userName, Date date) throws SQLException {
        Map<Integer, List> meetingDetails = new LinkedHashMap<Integer, List>();
    try {
        String sql = "select Meeting.facultyId, Meeting.date, Meeting.slot, Meeting.studentId from Meeting \n" +
                "inner join Faculty on Meeting.facultyId = Faculty.facultyId \n" +
                "where Faculty.userName = '"+ userName + "' and Meeting.date = '"+date+"'";
        connectionManager.executeRead(sql);
        ResultSet result = connectionManager.executeResult(sql);
        while (result.next()) {
            List meetings = new ArrayList();
            meetings.add(result.getInt("facultyId"));
            meetings.add(result.getDate("date"));
            meetings.add(result.getString("slot"));
            meetings.add(result.getInt("studentId"));
            meetingDetails.put(keyOfMap,meetings);
            keyOfMap = keyOfMap + VALUE;
        }
    } catch (
    SQLException e) {
        e.printStackTrace();
    } finally {
        connectionManager.closeConnection();
    }
    return meetingDetails;
}
}
