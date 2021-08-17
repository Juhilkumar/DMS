package com.dms.studentaccount.interfaces;

import com.dms.studentaccount.StudentAccountModel;

import java.sql.SQLException;

public interface IStudentAccountDAO {
    StudentAccountModel getStudentAccountDetails(String userName) throws SQLException;
    void deductMoney(int studentId) throws SQLException;
    void depositMoney(int studentId) throws SQLException;
}
