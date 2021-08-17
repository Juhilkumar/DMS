package com.dms.courserating;


import com.dms.courserating.interfaces.ICourseRatingDAO;
import com.dms.courserating.interfaces.ICourseRatingModel;

import java.sql.SQLException;

public class CourseRatingModel implements ICourseRatingModel {
    private boolean courseRatingGiven;
    private ICourseRatingDAO courseRatingDAO;

    public CourseRatingModel(ICourseRatingDAO courseRatingDAO){
        this.courseRatingDAO = courseRatingDAO;
    }

    public boolean postCourseRating(int courseId, String userName, int ratingPoint) throws SQLException {
        courseRatingGiven = courseRatingDAO.postCourseRating(courseId,userName,ratingPoint);
        return courseRatingGiven;
    }
}
