package com.dms.salary;

import com.dms.salary.interfaces.IPayrollDAO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayrollDAOMock implements IPayrollDAO {
    private static final String USER_NAME ="bhargav";
    private static final int FACULTY_SALARY = 3000;
    private static final int FACULTY_ID = 10000;
    private static final int KEY = 1;

    public Map<Integer, List> getFacultySalaryDetails(String userName, String month, int year){
        Map<Integer,List> facultyDetails = new HashMap<>();
        List facultySalaryInfo = new ArrayList();
        if(StringUtils.equals(userName,USER_NAME)){
            facultySalaryInfo.add(FACULTY_ID);
            facultySalaryInfo.add(FACULTY_SALARY);
            facultySalaryInfo.add(month);
            facultySalaryInfo.add(year);
        }
        facultyDetails.put(KEY,facultySalaryInfo);
        return facultyDetails;
    }
}
