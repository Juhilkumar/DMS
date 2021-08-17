package com.dms.department;

import com.dms.department.interfaces.IDepartmentDAO;
import com.dms.department.interfaces.IDepartmentModel;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DepartmentModel implements IDepartmentModel {
    private final IDepartmentDAO iDepartmentDao;
    public DepartmentModel(IDepartmentDAO iDepartmentDao) {
        this.iDepartmentDao = iDepartmentDao;
    }

    public List<String> getCourses() throws SQLException{
        List<String> courses = iDepartmentDao.getCourses();
        return courses;
    }

    public Map<String,String> getFaculty() throws SQLException{
        Map<String,String> faculty = iDepartmentDao.getFaculty();
        return faculty;
    }
}