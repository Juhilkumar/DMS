package com.dms.grade;

import com.dms.grade.abstractfactory.GradeAbstractFactoryTest;
import com.dms.grade.interfaces.IGradeHistoryModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

class GradeHistoryModelTest {
    private static final String COURSE_NAME = "cloudComputing";
    private static final int COURSE_ID = 5308;
    private static final String GRADE = "A+";
    private static final double CGPA1 = 10.0;
    private static final double CGPA2 = 0.0;

    GradeAbstractFactoryTest gradeAbstractFactoryTest;
    IGradeHistoryModel iGradeHistoryModel;

    @BeforeEach
    void init() {
        gradeAbstractFactoryTest = GradeAbstractFactoryTest.instance();
        iGradeHistoryModel = gradeAbstractFactoryTest.createGradeHistoryModel();

    }

    @Test
    void courseNamesListTest() throws SQLException {
        List courseNames = iGradeHistoryModel.courseNamesList("bhargav");
        Assertions.assertEquals(COURSE_NAME, courseNames.get(0));
    }

    @Test
    void calculateGradesTest() throws SQLException {
        Map<Integer, String> courseGrades = iGradeHistoryModel.calculateGrades("bhargav", "cloudComputing");
        Assertions.assertEquals(COURSE_ID, courseGrades.keySet().toArray()[0]);
        Assertions.assertEquals(GRADE, courseGrades.values().toArray()[0]);
    }

    @Test
    void scoreToLetterGradeTest() {
        Assertions.assertEquals(GRADE, iGradeHistoryModel.scoreToLetterGrade(92));
    }

    @Test
    void calculateCgpaTest() throws SQLException {
        Assertions.assertEquals(CGPA1, iGradeHistoryModel.calculateCgpa("bhargav", 1));
        Assertions.assertEquals(CGPA2, iGradeHistoryModel.calculateCgpa("bhargav1", 1));
    }

}