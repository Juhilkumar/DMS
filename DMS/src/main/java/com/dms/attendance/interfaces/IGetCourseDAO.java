package com.dms.attendance.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IGetCourseDAO {
    List<Integer> getCourseID(String username) throws SQLException;
}