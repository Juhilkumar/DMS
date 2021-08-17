package com.dms.salary;

import com.dms.salary.interfaces.IPayrollDAO;
import com.dms.salary.interfaces.IPayrollModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PayrollModel implements IPayrollModel {
    private final IPayrollDAO iPayRollDAO;
    public PayrollModel(IPayrollDAO iPayRollDAO) {
        this.iPayRollDAO = iPayRollDAO;
    }

    public Map<Integer, List> facultySalaryInfo(String userName,String month, int year) throws SQLException {
        Map<Integer, List> salaryList = iPayRollDAO.getFacultySalaryDetails(userName,month,year);
        return salaryList;
    }
}
