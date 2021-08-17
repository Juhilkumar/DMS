package com.dms.courserating;

import com.dms.courserating.interfaces.ICourseRatingDAO;

import java.sql.SQLException;

public class CourseRatingDAOMock implements ICourseRatingDAO {

    public boolean postCourseRating(int courseId, String userName, int ratingPoint) throws SQLException {
        boolean postCourseRatingTest = false;
        if (courseId == 5000 && userName == "Moksh" && ratingPoint == 4) {
            postCourseRatingTest = true;
        }
        return postCourseRatingTest;
    }
}
