package com.dms.salary.abstractfactory;

import com.dms.salary.FacultySalaryDAO;
import com.dms.salary.FacultySalaryModel;
import com.dms.salary.PayrollDAO;
import com.dms.salary.PayrollModel;
import com.dms.salary.interfaces.IFacultySalaryModel;
import com.dms.salary.interfaces.IPayrollModel;

public class SalaryConcreteFactory extends SalaryAbstractFactory{
    public IFacultySalaryModel createFacultySalaryModel(){
        return new FacultySalaryModel(new FacultySalaryDAO());
    }
    public IPayrollModel createPayrollModel(){
        return new PayrollModel(new PayrollDAO());
    }
}
