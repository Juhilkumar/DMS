package com.dms.studentaccount.abstractfactory;

import com.dms.studentaccount.interfaces.IStudentAccountDAO;
import com.dms.studentaccount.interfaces.IStudentAccountModel;

public abstract class StudentAccountAbstractFactory {

    private static StudentAccountAbstractFactory uniqueInstance = null;

    public abstract IStudentAccountModel createStudentAccountModel();
    public abstract IStudentAccountDAO createStudentAccountDAO();

    public static StudentAccountAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new StudentAccountConcreteFactory();
        }
        return uniqueInstance;
    }

}
