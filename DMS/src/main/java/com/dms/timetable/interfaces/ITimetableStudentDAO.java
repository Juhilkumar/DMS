package com.dms.timetable.interfaces;

import java.sql.SQLException;
import java.util.Map;

public interface ITimetableStudentDAO {
    Map<Integer,String> getTimetable(String username) throws SQLException;
}