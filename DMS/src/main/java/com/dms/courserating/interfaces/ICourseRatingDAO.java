package com.dms.courserating.interfaces;

import java.sql.SQLException;

public interface ICourseRatingDAO {
    boolean postCourseRating(int courseId, String userName, int ratingPoint) throws SQLException;
}
