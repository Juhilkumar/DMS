package com.dms.salary;


import com.dms.salary.abstractfactory.SalaryAbstractFactoryTest;
import com.dms.salary.interfaces.IPayrollModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;

class PayRollModelTest {
    SalaryAbstractFactoryTest salaryAbstractFactoryTest;
    IPayrollModel iPayRollModel;

    @BeforeEach
    void init() {
        salaryAbstractFactoryTest = SalaryAbstractFactoryTest.instance();
        iPayRollModel = salaryAbstractFactoryTest.createPayrollModel();
    }
    @Test
    void facultySalaryInfoTest() throws SQLException {

        Map<Integer, List> salaryList =iPayRollModel.facultySalaryInfo("bhargav","December",2020);
        assertAll(
                () -> Assertions.assertEquals(1, salaryList.keySet().toArray()[0]),
                () -> Assertions.assertEquals(10000, salaryList.get(1).get(0)),
                () -> Assertions.assertEquals(3000, salaryList.get(1).get(1)),
                () -> Assertions.assertEquals("December", salaryList.get(1).get(2)),
                () -> Assertions.assertEquals(2020, salaryList.get(1).get(3))

        );
    }
}