package com.dms.department.abstractfactory;

import com.dms.department.DepartmentDAO;
import com.dms.department.DepartmentModel;
import com.dms.department.interfaces.IDepartmentModel;

public class DepartmentConcreteFactory extends DepartmentAbstractFactory{
    public DepartmentDAO departmentDAO() {
        return new DepartmentDAO();
    }

    public IDepartmentModel iDepartmentModel() {
        return new DepartmentModel(departmentDAO());
    }
}