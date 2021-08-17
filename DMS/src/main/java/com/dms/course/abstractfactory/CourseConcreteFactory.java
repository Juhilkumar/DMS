package com.dms.course.abstractfactory;

import com.dms.course.CourseDAO;
import com.dms.course.interfaces.ICourseDAO;

public class CourseConcreteFactory extends CourseAbstractFactory{

    public ICourseDAO createCourseDAO() {
        return new CourseDAO();
    }
}
