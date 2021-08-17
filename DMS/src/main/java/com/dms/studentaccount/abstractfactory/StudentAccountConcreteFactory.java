package com.dms.studentaccount.abstractfactory;

import com.dms.studentaccount.StudentAccountDAO;
import com.dms.studentaccount.StudentAccountModel;
import com.dms.studentaccount.interfaces.IStudentAccountDAO;
import com.dms.studentaccount.interfaces.IStudentAccountModel;

public class StudentAccountConcreteFactory extends StudentAccountAbstractFactory{
    public IStudentAccountModel createStudentAccountModel(){
        return new StudentAccountModel(new StudentAccountDAO());
    }
    public IStudentAccountDAO createStudentAccountDAO(){
        return new StudentAccountDAO();
    }
}
