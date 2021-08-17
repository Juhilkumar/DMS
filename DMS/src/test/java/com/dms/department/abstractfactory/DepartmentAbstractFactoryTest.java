package com.dms.department.abstractfactory;

import com.dms.department.DepartmentDAOMock;
import com.dms.department.interfaces.IDepartmentModel;

public abstract class DepartmentAbstractFactoryTest {
    private static DepartmentAbstractFactoryTest uniqueInstance = null;

    public abstract DepartmentDAOMock departmentDAOMock();
    public abstract IDepartmentModel iDepartmentModel();

    public static DepartmentAbstractFactoryTest instance(){
        if(null == uniqueInstance){
            uniqueInstance = new DepartmentConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}