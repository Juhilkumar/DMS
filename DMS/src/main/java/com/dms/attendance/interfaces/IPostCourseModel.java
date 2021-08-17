package com.dms.attendance.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IPostCourseModel {
    List<Integer> getCourseIDForFaculty(String userName) throws SQLException;
}