package com.dms.courserating.abstractfactory;

import com.dms.courserating.interfaces.ICourseRatingModel;


public abstract class CourseRatingAbstractFactory {
    private static CourseRatingAbstractFactory uniqueInstance = null;

    public abstract ICourseRatingModel createCourseRatingModel();

    public static CourseRatingAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new CourseRatingConcreteFactory();
        }
        return uniqueInstance;
    }
}
