package com.dms.salary.abstractfactory;

import com.dms.salary.interfaces.IFacultySalaryModel;
import com.dms.salary.interfaces.IPayrollModel;

public abstract class SalaryAbstractFactoryTest {
    private static SalaryAbstractFactoryTest uniqueInstance = null;
    public abstract IFacultySalaryModel createFacultySalaryModel();
    public abstract IPayrollModel createPayrollModel();
    public static SalaryAbstractFactoryTest instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new SalaryConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}
