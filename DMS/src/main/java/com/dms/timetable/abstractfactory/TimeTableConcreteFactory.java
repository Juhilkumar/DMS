package com.dms.timetable.abstractfactory;

import com.dms.timetable.TimeTableFacultyDAO;
import com.dms.timetable.TimeTableFacultyModel;
import com.dms.timetable.TimeTableStudentModel;
import com.dms.timetable.TimetableStudentDAO;
import com.dms.timetable.interfaces.ITimeTableFacultyModel;
import com.dms.timetable.interfaces.ITimeTableStudentModel;

public class TimeTableConcreteFactory extends TimeTableAbstractFactory {
    public TimeTableFacultyDAO timeTableFacultyDAO() {
        return new TimeTableFacultyDAO();
    }

    public ITimeTableFacultyModel iTimeTableFacultyModel() {
        return new TimeTableFacultyModel(timeTableFacultyDAO());
    }

    public TimetableStudentDAO timetableStudentDAO() {
        return new TimetableStudentDAO();
    }

    public ITimeTableStudentModel iTimeTableStudentModel() {
        return new TimeTableStudentModel(timetableStudentDAO());
    }
}