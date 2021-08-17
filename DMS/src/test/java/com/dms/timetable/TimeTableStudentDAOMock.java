package com.dms.timetable;

import com.dms.timetable.interfaces.ITimetableStudentDAO;
import org.apache.commons.lang3.StringUtils;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TimeTableStudentDAOMock implements ITimetableStudentDAO {
    private static final String STUDENT = "Parth";
    private static final String TIMETABLE = "Monday 10:00am to 11:30am";
    private static final int COURSE = 5308;

    public Map<Integer, String> getTimetable(String username) throws SQLException {
        Map<Integer,String> timetable = new HashMap<>();
        if(StringUtils.equals(username,STUDENT)) {
            timetable.put(COURSE,TIMETABLE);
        }
        return timetable;
    }
}