package com.dms.salary.interfaces;

import java.sql.SQLException;
import java.util.Map;

public interface IFacultySalary {
    Map<Integer, String> getFacultySalaryDetails() throws SQLException;
    float getCourseRatingAvg( int FacultyID) throws SQLException;
    boolean insertFacultySalary(int facultyID, int salary, String month, int year) throws SQLException;
    boolean checkFacultySalary(int facultyID, String month, int year) throws SQLException;
    boolean updateFacultySalary(int facultyID, int salary, String month, int year) throws SQLException;
}
