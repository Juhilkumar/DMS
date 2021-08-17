package com.dms.grade;

import com.dms.grade.abstractfactory.GradeAbstractFactoryTest;
import com.dms.grade.interfaces.IPostGradesModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;

class PostGradesModelTest {
    private static final String COURSE_NAME = "CloudComputing";
    private static final String DEFAULT = "NotAvailable";
    private static final int GRADE = 70;
    private static final int STUDENT_ID = 202101;
    private static final int COURSE_ID = 5308;

    GradeAbstractFactoryTest gradeAbstractFactoryTest;
    IPostGradesModel iPostGradesModel;

    @BeforeEach
    void init() {
        gradeAbstractFactoryTest = GradeAbstractFactoryTest.instance();
        iPostGradesModel = gradeAbstractFactoryTest.createPostGradesModel();
    }

    @Test
    void courseNamesListTest() throws SQLException {
        List<String> courseNames;
        courseNames = iPostGradesModel.courseNamesList("bhargav");
        Assertions.assertEquals(COURSE_NAME, courseNames.get(0));
        courseNames = iPostGradesModel.courseNamesList("bhargav1");
        Assertions.assertEquals(DEFAULT,courseNames.get(0));
    }

    @Test
    void getStudentDetailsTest() throws SQLException {
        Map<Integer, List<Integer>> studentDetails = iPostGradesModel.getStudentDetails("bhargav","cloudComputing");
        Assertions.assertEquals(STUDENT_ID, studentDetails.keySet().toArray()[0]);
        int courseId = studentDetails.get(STUDENT_ID).get(0);
        Assertions.assertEquals(COURSE_ID,courseId);
        int marks = studentDetails.get(STUDENT_ID).get(1);
        Assertions.assertEquals(GRADE,marks);
    }

    @Test
    void postGradesTest() throws SQLException{
        assertAll(
                () -> Assertions.assertEquals(true,iPostGradesModel.postGrades(70,202101,5308)),
                () -> Assertions.assertEquals(false,iPostGradesModel.postGrades(22,22222,5308))
        );
    }
}






