package com.dms.attendance;

import com.dms.attendance.abstractfactory.AttendanceAbstractFactoryTest;
import com.dms.attendance.interfaces.IGetCourseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCourseModelTest {
    AttendanceAbstractFactoryTest attendanceAbstractFactoryTest;
    IGetCourseModel iGetCourseModel;

    @BeforeEach
    void init() {
        attendanceAbstractFactoryTest = AttendanceAbstractFactoryTest.instance();
        iGetCourseModel = attendanceAbstractFactoryTest.iGetCourseModel();
    }

    @Test
    public void getCourseIDTest() throws SQLException {
        List<Integer> courseId = new ArrayList<>();
        courseId = iGetCourseModel.getCourseID("Parth");
        assertEquals(5100, courseId.get(0).intValue());
    }
}