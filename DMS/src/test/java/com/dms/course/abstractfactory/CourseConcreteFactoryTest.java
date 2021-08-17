package com.dms.course.abstractfactory;

import com.dms.course.CourseDAOMock;
import com.dms.course.interfaces.ICourseDAO;

public class CourseConcreteFactoryTest extends CourseAbstractFactoryTest{
    public ICourseDAO createCourseDAOMock() {
        return new CourseDAOMock();
    }
}