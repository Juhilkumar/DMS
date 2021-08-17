package com.dms.attendance.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IPostCourseDAO {
    List<Integer> getCourseIDForFaculty(String username) throws SQLException;
}