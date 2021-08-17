package com.dms.timetable;

import com.dms.timetable.abstractfactory.TimeTableAbstractFactoryTest;
import com.dms.timetable.interfaces.ITimeTableFacultyModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTableFacultyModelTest {
    TimeTableAbstractFactoryTest timeTableAbstractFactoryTest;
    ITimeTableFacultyModel iTimeTableFacultyModel;

    @BeforeEach
    void init() {
        timeTableAbstractFactoryTest = TimeTableAbstractFactoryTest.instance();
        iTimeTableFacultyModel = timeTableAbstractFactoryTest.iTimeTableFacultyModel();
    }

    @Test
    public void getTimetableTest() throws SQLException {
        Map<Integer,String> timetable = new HashMap<>();
        timetable = iTimeTableFacultyModel.getTimetable("faculty");
        assertEquals("Monday 10:00am to 11:30am",timetable.get(5308));
    }
}