package com.dms.courserating;

import com.dms.courserating.abstractfactory.CourseRatingAbstractFactory;
import com.dms.courserating.interfaces.ICourseRatingModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


class CourseRatingModelTest {
    CourseRatingAbstractFactory courseRatingAbstractFactory;
    ICourseRatingModel iCourseRatingModel;

    @BeforeEach
    void init() {
        courseRatingAbstractFactory = CourseRatingAbstractFactory.instance();
        iCourseRatingModel = courseRatingAbstractFactory.createCourseRatingModel();
    }

    @Test
    void postCourseRating() throws SQLException {
        boolean posCourseRatingTestFlag = iCourseRatingModel.postCourseRating(5000, "Moksh", 4);
        Assertions.assertTrue(posCourseRatingTestFlag);
    }
}