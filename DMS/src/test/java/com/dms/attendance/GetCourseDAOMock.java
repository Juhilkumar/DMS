package com.dms.attendance;

import com.dms.attendance.interfaces.IGetCourseDAO;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetCourseDAOMock implements IGetCourseDAO {
    private static final String USERNAME = "Parth";
    private static final int COURSE = 5100;

    public List<Integer> getCourseID(String username) throws SQLException {
        List<Integer> course_id = new ArrayList<>();
        if (StringUtils.equals(username, USERNAME)) {
            course_id.add(COURSE);
        } else {
            course_id.add(-1);
        }
        return course_id;
    }
}