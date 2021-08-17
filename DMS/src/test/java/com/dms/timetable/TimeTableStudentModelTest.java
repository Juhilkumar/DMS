package com.dms.timetable;

import com.dms.timetable.abstractfactory.TimeTableAbstractFactoryTest;
import com.dms.timetable.interfaces.ITimeTableStudentModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTableStudentModelTest {
    TimeTableAbstractFactoryTest timeTableAbstractFactoryTest;
    ITimeTableStudentModel iTimeTableStudentModel;

    @BeforeEach
    void init() {
        timeTableAbstractFactoryTest = TimeTableAbstractFactoryTest.instance();
        iTimeTableStudentModel = timeTableAbstractFactoryTest.iTimeTableStudentModel();
    }

    @Test
    public void getTimetableTest() throws SQLException {
        Map<Integer,String> timetable = new HashMap<>();
        timetable = iTimeTableStudentModel.getTimetable("Parth");
        assertEquals("Monday 10:00am to 11:30am",timetable.get(5308));
    }
}