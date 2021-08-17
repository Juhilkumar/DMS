package com.dms.timetable.abstractfactory;

import com.dms.timetable.TimeTableFacultyDAO;
import com.dms.timetable.TimetableStudentDAO;
import com.dms.timetable.interfaces.ITimeTableFacultyModel;
import com.dms.timetable.interfaces.ITimeTableStudentModel;

public abstract class TimeTableAbstractFactory {
    private static TimeTableAbstractFactory uniqueInstance = null;

    public abstract TimeTableFacultyDAO timeTableFacultyDAO();
    public abstract ITimeTableFacultyModel iTimeTableFacultyModel();
    public abstract TimetableStudentDAO timetableStudentDAO();
    public abstract ITimeTableStudentModel iTimeTableStudentModel();

    public static TimeTableAbstractFactory instance(){
        if(null == uniqueInstance){
            uniqueInstance = new TimeTableConcreteFactory();
        }
        return uniqueInstance;
    }
}