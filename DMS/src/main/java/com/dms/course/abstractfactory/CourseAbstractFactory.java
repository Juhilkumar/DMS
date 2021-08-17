package com.dms.course.abstractfactory;

import com.dms.course.interfaces.ICourseDAO;

public abstract class CourseAbstractFactory {

    private static CourseAbstractFactory uniqueInstance = null;

    public abstract ICourseDAO createCourseDAO();


    public static CourseAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new CourseConcreteFactory();
        }
        return uniqueInstance;
    }
}
