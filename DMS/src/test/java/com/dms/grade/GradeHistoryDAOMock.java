package com.dms.grade;

import com.dms.grade.interfaces.IGradeHistory;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeHistoryDAOMock implements IGradeHistory {

    private static final String USER_NAME = "bhargav";
    private static final int COURSE_ID1 = 5308;
    private static final int MARKS1 = 92;
    private static final int COURSE_ID2 = 0;
    private static final int MARKS2 = 0;
    private static final int SEMESTER = 1;
    private static final String COURSE_NAME = "cloudComputing";
    private static final String DEFAULT_COURSE_NAME = "XYZ";

    public List<String> getRegisteredCourses(String userName) {
        List<String> courses = new ArrayList<String>();
        if (StringUtils.equals(userName, USER_NAME)) {
            courses.add(COURSE_NAME);
        } else {
            courses.add(DEFAULT_COURSE_NAME);
        }
        return courses;
    }

    public Map<Integer, Integer> getGrades(String userName, String courseName) {
        Map<Integer, Integer> gradeList = new HashMap<Integer, Integer>();
        if (StringUtils.equals(userName, USER_NAME) && StringUtils.equals(courseName, COURSE_NAME)) {
            gradeList.put(COURSE_ID1, MARKS1);
        } else {
            gradeList.put(COURSE_ID2, MARKS2);
        }
        return gradeList;
    }

    public List<Integer> allGrades(String userName, int semester) {
        List<Integer> marks = new ArrayList<Integer>();
        if (StringUtils.equals(userName, USER_NAME) && semester == SEMESTER) {
            marks.add(MARKS1);
        } else {
            marks.add(MARKS2);
        }
        return marks;
    }
}
