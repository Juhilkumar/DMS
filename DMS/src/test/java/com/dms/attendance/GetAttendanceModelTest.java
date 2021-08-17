package com.dms.attendance;

import com.dms.attendance.abstractfactory.AttendanceAbstractFactoryTest;
import com.dms.attendance.interfaces.IGetAttendanceModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

public class GetAttendanceModelTest {
    AttendanceAbstractFactoryTest attendanceAbstractFactoryTest;
    IGetAttendanceModel iGetAttendanceModel;

    @BeforeEach
    void init() {
        attendanceAbstractFactoryTest = AttendanceAbstractFactoryTest.instance();
        iGetAttendanceModel = attendanceAbstractFactoryTest.iGetAttendanceModel();
    }

    @Test
    public void retrievingAttendanceTest() throws SQLException {
        assertEquals(50, iGetAttendanceModel.retrievingAttendance("Parth", 5100));
    }
}