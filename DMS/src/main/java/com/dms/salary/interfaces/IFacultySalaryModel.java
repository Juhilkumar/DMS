package com.dms.salary.interfaces;

import java.sql.SQLException;
import java.util.Map;

public interface IFacultySalaryModel {
    Map<Integer, String> facultyDetails() throws SQLException;
    boolean updateSalary(int facultyID, int salary, int month, int year) throws SQLException;
    String convertMonth(int Month);
}
