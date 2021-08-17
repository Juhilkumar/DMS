package com.dms.courserating.abstractfactory;

import com.dms.courserating.CourseRatingDAO;
import com.dms.courserating.CourseRatingModel;
import com.dms.courserating.interfaces.ICourseRatingDAO;
import com.dms.courserating.interfaces.ICourseRatingModel;

public class CourseRatingConcreteFactory extends CourseRatingAbstractFactory{
    public ICourseRatingModel createCourseRatingModel(){
        return new CourseRatingModel(createCourseRatingDAO());
    }
    public ICourseRatingDAO createCourseRatingDAO(){
        return new CourseRatingDAO();
    };
}
