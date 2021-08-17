package com.dms.timetable;

import com.dms.timetable.interfaces.ITimeTableStudentModel;
import com.dms.timetable.interfaces.ITimetableStudentDAO;
import java.sql.SQLException;
import java.util.Map;

public class TimeTableStudentModel implements ITimeTableStudentModel {
    private final ITimetableStudentDAO timetableStudentDao;
    public TimeTableStudentModel(ITimetableStudentDAO timetableStudentDao) {
        this.timetableStudentDao = timetableStudentDao;
    }

    public Map<Integer,String> getTimetable(String userName) throws SQLException {
        Map<Integer,String> timetable = timetableStudentDao.getTimetable(userName);
        return timetable;
    }
}