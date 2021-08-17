package com.dms.course.abstractfactory;

import com.dms.course.interfaces.ICourseDAO;

public abstract class CourseAbstractFactoryTest {
    private static CourseAbstractFactoryTest uniqueInstance = null;
    public abstract ICourseDAO createCourseDAOMock();

    public static CourseAbstractFactoryTest instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new CourseConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}