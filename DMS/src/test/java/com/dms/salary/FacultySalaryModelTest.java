package com.dms.salary;

import com.dms.salary.abstractfactory.SalaryAbstractFactoryTest;
import com.dms.salary.interfaces.IFacultySalaryModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;

class FacultySalaryModelTest {
    private static final int FACULTY_ID = 10000;
    private static final String MONTH ="April";
    private static final String DESIGNATION ="Professor";


    SalaryAbstractFactoryTest salaryAbstractFactoryTest;
    IFacultySalaryModel iFacultySalaryModel;

    @BeforeEach
    void init() {
        salaryAbstractFactoryTest = SalaryAbstractFactoryTest.instance();
        iFacultySalaryModel = salaryAbstractFactoryTest.createFacultySalaryModel();

    }
        @Test
        void convertMonthTest(){
            Assertions.assertEquals(MONTH,iFacultySalaryModel.convertMonth(4));
        }
        @Test
        void facultydetailsTest() throws SQLException {
            Map<Integer, String> facultyDetails= iFacultySalaryModel.facultyDetails();
            assertAll(
                    () -> Assertions.assertEquals(FACULTY_ID, facultyDetails.keySet().toArray()[0]),
                    () -> Assertions.assertEquals(DESIGNATION, facultyDetails.values().toArray()[0])
            );
        }
        @Test
         void updateSalaryTest(){
             assertAll(
                () -> Assertions.assertEquals(true,iFacultySalaryModel.updateSalary(11111,4000,1,2021)),
                () -> Assertions.assertEquals(false,iFacultySalaryModel.updateSalary(11111,2000,1,2021)),
                () -> Assertions.assertEquals(true,iFacultySalaryModel.updateSalary(10000,4000,1,2021)),
                () -> Assertions.assertEquals(false,iFacultySalaryModel.updateSalary(10000,2000,1,2021))
             );
    }
}