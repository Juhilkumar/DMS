package com.dms.salary;

import com.dms.salary.interfaces.IFacultySalary;
import com.dms.salary.interfaces.IFacultySalaryModel;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FacultySalaryModel implements IFacultySalaryModel {
    private static final int BONUS = 2000;
    private static final String Month1="January";
    private static final String Month2="February";
    private static final String Month3="March";
    private static final String Month4="April";
    private static final String Month5="May";
    private static final String Month6="June";
    private static final String Month7="July";
    private static final String Month8="August";
    private static final String Month9="September";
    private static final String Month10="October";
    private static final String Month11="November";
    private static final String Month12="December";
    private static final int BONUS_MONTH1=4;
    private static final int BONUS_MONTH2=8;
    private static final int BONUS_MONTH3=12;
    private static final float MIN_AVERAGE_FOR_BONUS= 3.5F;

    private IFacultySalary iFacultySalary;

    public FacultySalaryModel(IFacultySalary iFacultySalary) {
        this.iFacultySalary = iFacultySalary;
    }

    @Override
    public Map<Integer, String> facultyDetails() throws SQLException {
        Map<Integer, String> facultyDetails =iFacultySalary.getFacultySalaryDetails();
        return facultyDetails;
    }

    @Override
    public boolean updateSalary(int facultyID, int salary, int month, int year) throws SQLException {
        boolean salaryUpdated = false;
        float averageOfCourseRating = iFacultySalary.getCourseRatingAvg(facultyID);
        if((month== BONUS_MONTH1 || month == BONUS_MONTH2 || month == BONUS_MONTH3) && averageOfCourseRating >= MIN_AVERAGE_FOR_BONUS){
            salary = salary +BONUS;
        }
        String convertedMonth=convertMonth(month);
        boolean salaryExists = iFacultySalary.checkFacultySalary(facultyID,convertedMonth,year);
        if (salaryExists){
        salaryUpdated = iFacultySalary.updateFacultySalary(facultyID,salary,convertedMonth, year);
        }
        else {
            salaryUpdated=iFacultySalary.insertFacultySalary(facultyID,salary,convertedMonth, year);
        }
        return salaryUpdated;
    }

    @Override
    public String convertMonth(int monthToBeConverted){
        Map<Integer,String> month = new HashMap<Integer,String>();
        month.put(1,Month1);
        month.put(2,Month2);
        month.put(3,Month3);
        month.put(4,Month4);
        month.put(5,Month5);
        month.put(6,Month6);
        month.put(7,Month7);
        month.put(8,Month8);
        month.put(9,Month9);
        month.put(10,Month10);
        month.put(11,Month11);
        month.put(12,Month12);
        return month.get(monthToBeConverted);
    }
}
