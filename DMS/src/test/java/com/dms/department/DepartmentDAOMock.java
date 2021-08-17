package com.dms.department;

import com.dms.department.interfaces.IDepartmentDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDAOMock implements IDepartmentDAO {
    private static final String COURSE = "cloud computing";
    private static final String FACULTY = "faculty";
    private static final String PROFESSION = "professor";

    public List<String> getCourses() throws SQLException {
        List<String> course = new ArrayList<>();
        course.add(COURSE);
        return course;
    }

    public Map<String, String> getFaculty() throws SQLException {
        Map<String, String> faculty = new HashMap<>();
        faculty.put(FACULTY, PROFESSION);
        return faculty;
    }
}