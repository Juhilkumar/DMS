package com.dms.timetable.abstractfactory;

import com.dms.timetable.TimeTableFacultyDAOMock;
import com.dms.timetable.TimeTableFacultyModel;
import com.dms.timetable.TimeTableStudentDAOMock;
import com.dms.timetable.TimeTableStudentModel;
import com.dms.timetable.interfaces.ITimeTableFacultyModel;
import com.dms.timetable.interfaces.ITimeTableStudentModel;

public class TimeTableConcreteFactoryTest extends TimeTableAbstractFactoryTest{
    public TimeTableFacultyDAOMock timeTableFacultyDAOMock() {
        return new TimeTableFacultyDAOMock();
    }

    public ITimeTableFacultyModel iTimeTableFacultyModel() {
        return new TimeTableFacultyModel(timeTableFacultyDAOMock());
    }

    public TimeTableStudentDAOMock timeTableStudentDAOMock() {
        return new TimeTableStudentDAOMock();
    }

    public ITimeTableStudentModel iTimeTableStudentModel() {
        return new TimeTableStudentModel(timeTableStudentDAOMock());
    }
}