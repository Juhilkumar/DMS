package com.dms.salary.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IPayrollModel {
    Map<Integer, List> facultySalaryInfo(String userName, String month, int year) throws SQLException;
}
