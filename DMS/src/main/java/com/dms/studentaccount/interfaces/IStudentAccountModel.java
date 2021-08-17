package com.dms.studentaccount.interfaces;

import java.sql.SQLException;

public interface IStudentAccountModel {
    void deductMoney(int studentId) throws SQLException;
    void depositMoney(int studentId) throws SQLException;
}
