package com.dms.meeting;

import com.dms.meeting.abstractfactory.MeetingAbstractFactoryTest;
import com.dms.meeting.interfaces.IViewMeetingsModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;

class ViewMeetingsModelTest {
    private static final int FACULTY_ID =10000;
    private static final int DATE =2021 - 03 - 24;
    private static final String SLOT ="3:00 PM";
    private static final int STUDENT_ID =11111;
    private static final String NO_MEETINGS ="No Meetings";


    MeetingAbstractFactoryTest meetingAbstractFactoryTest;
    IViewMeetingsModel iViewMeetingsModel;

    @BeforeEach
    void init() {
        meetingAbstractFactoryTest = MeetingAbstractFactoryTest.instance();
        iViewMeetingsModel = meetingAbstractFactoryTest.createViewMeetingsModel();
    }
    @Test
    void ViewMeetingsTest() throws SQLException {
        Date today = new Date(System.currentTimeMillis());
        Map<Integer, List> meetingsList = iViewMeetingsModel.meetingsInformation("bhargav",today);
        Map<Integer, List> meetingsList1= iViewMeetingsModel.meetingsInformation("bhargav1",today);
        assertAll(
                () -> Assertions.assertEquals(FACULTY_ID, meetingsList.get(1).get(0)),
                () -> Assertions.assertEquals(DATE, meetingsList.get(1).get(1)),
                () -> Assertions.assertEquals(SLOT, meetingsList.get(1).get(2)),
                () -> Assertions.assertEquals(STUDENT_ID, meetingsList.get(1).get(3)),
                () -> Assertions.assertEquals(NO_MEETINGS, meetingsList1.get(1).get(0)),
                () -> Assertions.assertEquals(NO_MEETINGS, meetingsList1.get(1).get(0))

        );
    }
}