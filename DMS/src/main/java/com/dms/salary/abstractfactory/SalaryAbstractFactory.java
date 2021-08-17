package com.dms.salary.abstractfactory;

import com.dms.salary.interfaces.IFacultySalaryModel;
import com.dms.salary.interfaces.IPayrollModel;

public abstract class SalaryAbstractFactory {
    private static SalaryAbstractFactory uniqueInstance = null;
    public abstract IFacultySalaryModel createFacultySalaryModel();
    public abstract IPayrollModel createPayrollModel();
    public static SalaryAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new SalaryConcreteFactory();
        }
        return uniqueInstance;
    }
}
