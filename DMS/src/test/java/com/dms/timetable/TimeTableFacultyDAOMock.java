package com.dms.timetable;

import com.dms.timetable.interfaces.ITimeTableFacultyDAO;
import org.apache.commons.lang3.StringUtils;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TimeTableFacultyDAOMock implements ITimeTableFacultyDAO {
    private static final String FACULTY = "faculty";
    private static final String TIMETABLE = "Monday 10:00am to 11:30am";
    private static final int COURSE = 5308;

    public Map<Integer, String> getTimetable(String username) throws SQLException {
        Map<Integer,String> timetable = new HashMap<>();
        if(StringUtils.equals(username,FACULTY)) {
            timetable.put(COURSE,TIMETABLE);
        }
        return timetable;
    }
}