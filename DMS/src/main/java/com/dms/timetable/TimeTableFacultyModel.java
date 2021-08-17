package com.dms.timetable;

import com.dms.timetable.interfaces.ITimeTableFacultyDAO;
import com.dms.timetable.interfaces.ITimeTableFacultyModel;
import java.sql.SQLException;
import java.util.Map;

public class TimeTableFacultyModel implements ITimeTableFacultyModel {
    private final ITimeTableFacultyDAO timeTableFacultyDao;
    public TimeTableFacultyModel(ITimeTableFacultyDAO timeTableFacultyDao) {
        this.timeTableFacultyDao = timeTableFacultyDao;
    }

    public Map<Integer,String> getTimetable(String userName) throws SQLException {
        Map<Integer,String> timetable = timeTableFacultyDao.getTimetable(userName);
        return timetable;
    }
}