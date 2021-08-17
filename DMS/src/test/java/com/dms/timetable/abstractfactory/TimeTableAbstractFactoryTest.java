package com.dms.timetable.abstractfactory;

import com.dms.timetable.TimeTableFacultyDAOMock;
import com.dms.timetable.TimeTableStudentDAOMock;
import com.dms.timetable.interfaces.ITimeTableFacultyModel;
import com.dms.timetable.interfaces.ITimeTableStudentModel;

public abstract class TimeTableAbstractFactoryTest {
    private static TimeTableAbstractFactoryTest uniqueInstance = null;

    public abstract TimeTableFacultyDAOMock timeTableFacultyDAOMock();
    public abstract ITimeTableFacultyModel iTimeTableFacultyModel();
    public abstract TimeTableStudentDAOMock timeTableStudentDAOMock();
    public abstract ITimeTableStudentModel iTimeTableStudentModel();

    public static TimeTableAbstractFactoryTest instance(){
        if(null == uniqueInstance){
            uniqueInstance = new TimeTableConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}