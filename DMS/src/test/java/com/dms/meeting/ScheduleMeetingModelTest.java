package com.dms.meeting;

import com.dms.meeting.abstractfactory.MeetingAbstractFactoryTest;
import com.dms.meeting.interfaces.IScheduleMeetingModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleMeetingModelTest {
    private static final String COURSE_NAME ="Advanced Software Development Topics";
    private static final int COURSE_ID = 5308;
    private static final int FACULTY_ID = 10000;

    MeetingAbstractFactoryTest meetingAbstractFactoryTest;
    IScheduleMeetingModel iScheduleMeetingModel;
    @BeforeEach
    void init() {
        meetingAbstractFactoryTest = MeetingAbstractFactoryTest.instance();
        iScheduleMeetingModel = meetingAbstractFactoryTest.createScheduleMeetingModel();
    }

    @Test
    void facultyNamesListTest() throws SQLException {
        Map<Integer, List> facultyDetails = iScheduleMeetingModel.facultyNamesList("bhargav");
        assertAll(
                () -> Assertions.assertEquals(COURSE_ID, facultyDetails.get(1).get(0)),
                () -> Assertions.assertEquals(COURSE_NAME, facultyDetails.get(1).get(1)),
                () -> Assertions.assertEquals(FACULTY_ID, facultyDetails.get(1).get(2))
        );
    }

}