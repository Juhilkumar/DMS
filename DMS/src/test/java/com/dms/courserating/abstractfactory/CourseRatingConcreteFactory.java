package com.dms.courserating.abstractfactory;

import com.dms.courserating.CourseRatingDAOMock;
import com.dms.courserating.CourseRatingModel;
import com.dms.courserating.interfaces.ICourseRatingModel;

public class CourseRatingConcreteFactory extends CourseRatingAbstractFactory {
    public ICourseRatingModel createCourseRatingModel() {
        return new CourseRatingModel(new CourseRatingDAOMock());
    }
}
