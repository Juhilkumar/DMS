package com.dms.attendance;

import com.dms.attendance.abstractfactory.AttendanceAbstractFactoryTest;
import com.dms.attendance.interfaces.IPostAttendanceModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostAttendanceModelTest {
    AttendanceAbstractFactoryTest attendanceAbstractFactoryTest;
    IPostAttendanceModel iPostAttendanceModel;

    @BeforeEach
    void init() {
        attendanceAbstractFactoryTest = AttendanceAbstractFactoryTest.instance();
        iPostAttendanceModel = attendanceAbstractFactoryTest.iPostAttendanceModel();
    }

    @Test
    public void postAttendanceTest() throws SQLException {
        boolean result = iPostAttendanceModel.postAttendance(22123, 5308, "present");
        assertEquals(true, result);
    }
}