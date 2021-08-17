package com.dms.attendance.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IGetCourseModel {
    List<Integer> getCourseID(String userName) throws SQLException;
}