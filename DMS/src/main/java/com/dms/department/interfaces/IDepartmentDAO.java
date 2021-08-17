package com.dms.department.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IDepartmentDAO {
    List<String> getCourses() throws SQLException;
    Map<String,String> getFaculty() throws SQLException;
}