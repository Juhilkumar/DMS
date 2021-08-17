package com.dms.course;

import com.dms.course.interfaces.ICourseDAO;
import com.dms.course.abstractfactory.CourseAbstractFactoryTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class CourseDAOTest {
    CourseAbstractFactoryTest courseAbstractFactoryTest;
    ICourseDAO iCourseDAO;

    @BeforeEach
    void init() {
        courseAbstractFactoryTest = CourseAbstractFactoryTest.instance();
        iCourseDAO = courseAbstractFactoryTest.createCourseDAOMock();
    }

    @Test
    void getCourses() throws SQLException {
        ArrayList<Course> courseList = iCourseDAO.getCourses();
        Assertions.assertEquals(1, courseList.size());
    }

    @Test
    void registerCourse() throws SQLException {
        boolean flag = iCourseDAO.registerCourse(5000, "Moksh", 1);
        Assertions.assertEquals(true, flag);
    }

    @Test
    void withdrawCourse() throws SQLException {
        boolean flag = iCourseDAO.withdrawCourse(5000, "Moksh");
        Assertions.assertEquals(true, flag);
    }

    @Test
    void retrieveTimetable() throws SQLException {
        List<String> timetable = iCourseDAO.retrieveTimetable("admin");
        Assertions.assertEquals("Monday 13:00 to 14:30", timetable.get(0));
    }

    @Test
    void isCourseIdAlreadyTaken() throws SQLException {
        Assertions.assertTrue(iCourseDAO.isCourseIdAlreadyTaken(5000));
    }

    @Test
    void addCourse() throws SQLException {
        Assertions.assertTrue(iCourseDAO.addCourse(5000, "abc", 58754, "Wed, Sat 3:00 PM to 5:00 PM"));
    }
}
