package com.dms.classroom;

import com.dms.classroom.abstractfactory.ClassroomAbstractFactory;
import com.dms.classroom.interfaces.IClassroomModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

class ClassroomModelTest {
    ClassroomAbstractFactory classroomAbstractFactory;
    IClassroomModel iClassroomModel;

    @BeforeEach
    void init() {
        classroomAbstractFactory = ClassroomAbstractFactory.instance();
        iClassroomModel = classroomAbstractFactory.createClassroomModel();

    }


    @Test
    void postClassroomSchedule() throws SQLException {
        Date today = new java.sql.Date(System.currentTimeMillis());
        boolean flag = iClassroomModel.postClassroomSchedule("Moksh", 5000, "TDD", today, "12:00 PM", "1:00 PM");
        Assertions.assertTrue(flag);
    }

    @Test
    void showClassroomSchedule() throws SQLException {
        List<ClassroomModel> classSchedule = iClassroomModel.showClassroomSchedule("Moksh");
        Assertions.assertEquals(1, classSchedule.size());
    }
}