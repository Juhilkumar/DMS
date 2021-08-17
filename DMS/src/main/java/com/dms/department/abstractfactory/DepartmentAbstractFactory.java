package com.dms.department.abstractfactory;

import com.dms.department.DepartmentDAO;
import com.dms.department.interfaces.IDepartmentModel;

public abstract class DepartmentAbstractFactory {
    private static DepartmentAbstractFactory uniqueInstance = null;

    public abstract DepartmentDAO departmentDAO();
    public abstract IDepartmentModel iDepartmentModel();

    public static DepartmentAbstractFactory instance(){
        if(null == uniqueInstance){
            uniqueInstance = new DepartmentConcreteFactory();
        }
        return uniqueInstance;
    }
}