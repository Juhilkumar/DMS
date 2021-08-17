package com.dms.studentaccount;

import com.dms.studentaccount.interfaces.IStudentAccountDAO;
import com.dms.studentaccount.interfaces.IStudentAccountModel;

import java.sql.SQLException;

public class StudentAccountModel implements IStudentAccountModel {

    private int studentId;
    private int billedAmount;
    private int unbilledAmount;
    private int totalAmount;
    private IStudentAccountDAO studentAccountDAO;

    public StudentAccountModel(IStudentAccountDAO studentAccountDAO) {
        this.studentAccountDAO = studentAccountDAO;
    }

    public StudentAccountModel() {

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBilledAmount() {
        return billedAmount;
    }

    public void setBilledAmount(int billedAmount) {
        this.billedAmount = billedAmount;
    }

    public int getUnbilledAmount() {
        return unbilledAmount;
    }

    public void setUnbilledAmount(int unbilledAmount) {
        this.unbilledAmount = unbilledAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void deductMoney(int studentId) throws SQLException {
        studentAccountDAO.deductMoney(studentId);
    }

    public void depositMoney(int studentId) throws SQLException {
        studentAccountDAO.depositMoney(studentId);
    }

}
