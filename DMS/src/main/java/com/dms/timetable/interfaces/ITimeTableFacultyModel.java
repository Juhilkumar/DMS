package com.dms.timetable.interfaces;

import java.sql.SQLException;
import java.util.Map;

public interface ITimeTableFacultyModel {
    Map<Integer,String> getTimetable(String userName) throws SQLException;
}