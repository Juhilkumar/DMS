package com.dms.classroom.abstractfactory;

import com.dms.classroom.interfaces.IClassroomDAO;
import com.dms.classroom.interfaces.IClassroomModel;

public abstract class ClassroomAbstractFactory {
    private static ClassroomAbstractFactory uniqueInstance = null;

    public abstract IClassroomModel createClassroomModel();
    public abstract IClassroomDAO createClassroomDAO();

    public static ClassroomAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new ClassroomConcreteFactory();
        }
        return uniqueInstance;
    }
}
