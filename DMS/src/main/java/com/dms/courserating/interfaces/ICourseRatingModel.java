package com.dms.courserating.interfaces;

import java.sql.SQLException;

public interface ICourseRatingModel {
    boolean postCourseRating(int courseId, String userName, int ratingPoint) throws SQLException;
}
