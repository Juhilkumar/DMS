package com.dms.classroom.abstractfactory;

import com.dms.classroom.ClassroomDAOMock;
import com.dms.classroom.ClassroomModel;
import com.dms.classroom.interfaces.IClassroomModel;

public class ClassroomConcreteFactory extends ClassroomAbstractFactory{
    public IClassroomModel createClassroomModel(){ return new ClassroomModel(new ClassroomDAOMock()); };
}
