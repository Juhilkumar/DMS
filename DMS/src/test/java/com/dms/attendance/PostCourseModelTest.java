package com.dms.attendance;

import com.dms.attendance.abstractfactory.AttendanceAbstractFactoryTest;
import com.dms.attendance.interfaces.IPostCourseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostCourseModelTest {
    AttendanceAbstractFactoryTest attendanceAbstractFactoryTest;
    IPostCourseModel iPostCourseModel;

    @BeforeEach
    void init() {
        attendanceAbstractFactoryTest = AttendanceAbstractFactoryTest.instance();
        iPostCourseModel = attendanceAbstractFactoryTest.iPostCourseModel();
    }

    @Test
    public void getCourseIDForFacultyTest() throws SQLException {
        List<Integer> courseId = new ArrayList<>();
        courseId = iPostCourseModel.getCourseIDForFaculty("faculty");
        assertEquals(5308, courseId.get(0).intValue());
    }
}