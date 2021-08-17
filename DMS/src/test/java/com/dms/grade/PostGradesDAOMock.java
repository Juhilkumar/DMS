package com.dms.grade;

import com.dms.grade.interfaces.IPostGrades;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostGradesDAOMock implements IPostGrades {
    private static final String USER_NAME1 = "bhargav";
    private static final String COURSE_NAME = "CloudComputing";
    private static final int GRADE = 70;
    private static final int STUDENT_ID = 202101;
    private static final int COURSE_ID = 5308;
    private static final String DEFAULT = "NotAvailable";

    public List<String> getCourseNames(String userName) {
        List<String> courseNames = new ArrayList<String>();
        if (userName.equals(USER_NAME1)) {
            courseNames.add(COURSE_NAME);
        } else {
            courseNames.add(DEFAULT);
        }
        return courseNames;
    }

    public Map<Integer, List<Integer>> getStudentDetails(String userName, String courseName) {
        Map<Integer, List<Integer>> studentDetails = new HashMap<Integer, List<Integer>>();
        if (StringUtils.equals(userName, USER_NAME1)) {
            int studentId = STUDENT_ID;
            int courseId = COURSE_ID;
            int grade = GRADE;
            List<Integer> courseGrades = new ArrayList<>();
            courseGrades.add(courseId);
            courseGrades.add(grade);
            studentDetails.put(studentId, courseGrades);
            return studentDetails;
        }
        return studentDetails;
    }

    public boolean postGrades(int marks, int studentID, int courseId) {
        boolean gradesPosted = false;
        if (marks == GRADE && studentID == STUDENT_ID && courseId == COURSE_ID) {
            gradesPosted = true;
        }
        return gradesPosted;
    }
}
