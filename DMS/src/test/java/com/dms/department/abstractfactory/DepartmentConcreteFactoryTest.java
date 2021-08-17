package com.dms.department.abstractfactory;

import com.dms.department.DepartmentDAOMock;
import com.dms.department.DepartmentModel;
import com.dms.department.interfaces.IDepartmentModel;

public class DepartmentConcreteFactoryTest extends DepartmentAbstractFactoryTest{
    public DepartmentDAOMock departmentDAOMock() {
        return new DepartmentDAOMock();
    }

    public IDepartmentModel iDepartmentModel() {
        return new DepartmentModel(departmentDAOMock());
    }
}