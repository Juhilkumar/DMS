package com.dms.salary.abstractfactory;

import com.dms.salary.FacultySalaryDAOMock;
import com.dms.salary.*;
import com.dms.salary.interfaces.IFacultySalaryModel;
import com.dms.salary.interfaces.IPayrollModel;

public class SalaryConcreteFactoryTest extends SalaryAbstractFactoryTest {
    public IFacultySalaryModel createFacultySalaryModel(){
        return new FacultySalaryModel(new FacultySalaryDAOMock());
    }
    public IPayrollModel createPayrollModel(){
        return new PayrollModel(new PayrollDAOMock());
    }
}
