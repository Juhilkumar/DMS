package com.dms.classroom.abstractfactory;

import com.dms.classroom.ClassroomDAO;
import com.dms.classroom.ClassroomModel;
import com.dms.classroom.interfaces.IClassroomDAO;
import com.dms.classroom.interfaces.IClassroomModel;

public class ClassroomConcreteFactory extends ClassroomAbstractFactory{
    public IClassroomModel createClassroomModel(){ return new ClassroomModel(new ClassroomDAO()); };
    public IClassroomDAO createClassroomDAO(){ return new ClassroomDAO(); };
}
