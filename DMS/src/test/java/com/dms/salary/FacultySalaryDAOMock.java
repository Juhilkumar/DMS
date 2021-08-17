package com.dms.salary;

import com.dms.salary.interfaces.IFacultySalary;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FacultySalaryDAOMock implements IFacultySalary {
    private static final int FACULTY_ID = 10000;
    private static final int FACULTY_ID1 = 11111;
    private static final String DESIGNATION ="Professor";
    private static final int DEFAULT_COURSE_RATING_AVERAGE=0;
    private static final int COURSE_RATING_AVERAGE=4;
    private static final int SALARY1 = 4000;
    private static final String MONTH1 = "January";
    private static final int YEAR1 = 2021;



    public Map<Integer, String> getFacultySalaryDetails(){
        Map<Integer, String> facultyDetails = new HashMap<Integer,String>();
        facultyDetails.put(FACULTY_ID,DESIGNATION);
        return facultyDetails;
    }

    public float getCourseRatingAvg( int FacultyID) {
        float courseRatingAvg = DEFAULT_COURSE_RATING_AVERAGE;
        if(FacultyID == FACULTY_ID1){
            courseRatingAvg = COURSE_RATING_AVERAGE;
            return courseRatingAvg;

        }
        else {
            return courseRatingAvg;
        }

    }

    public  boolean insertFacultySalary(int facultyID, int salary, String month, int year){
        boolean salaryInserted = false;
        if(facultyID == FACULTY_ID && salary == SALARY1 && month == MONTH1 && year == YEAR1){
            salaryInserted = true;
        }
        return salaryInserted;
    }

    public boolean checkFacultySalary(int facultyID, String month, int year){
        boolean salaryExists= false;
        if(facultyID == FACULTY_ID1 && month == MONTH1 && year == YEAR1){
            salaryExists= true;
        }
        else if (facultyID == FACULTY_ID && month == MONTH1 && year == YEAR1){
            salaryExists =  false;
        }
        return salaryExists;
    }

    public boolean updateFacultySalary(int facultyID, int salary, String month, int year){
        boolean salaryUpdated = false;
        if(facultyID == FACULTY_ID1 && salary == SALARY1 && month == MONTH1 && year == YEAR1){
            salaryUpdated = true;
        }
        return salaryUpdated;
    }
}
