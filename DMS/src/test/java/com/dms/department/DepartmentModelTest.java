package com.dms.department;

import com.dms.department.abstractfactory.DepartmentAbstractFactoryTest;
import com.dms.department.interfaces.IDepartmentModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentModelTest {
    DepartmentAbstractFactoryTest departmentAbstractFactoryTest;
    IDepartmentModel iDepartmentModel;

    @BeforeEach
    void init() {
        departmentAbstractFactoryTest = DepartmentAbstractFactoryTest.instance();
        iDepartmentModel = departmentAbstractFactoryTest.iDepartmentModel();
    }

    @Test
    public void getCoursesTest() throws SQLException {
        List<String> course = iDepartmentModel.getCourses();
        assertEquals("cloud computing", course.get(0));
    }

    @Test
    public void getFacultyTest() throws SQLException {
        Map<String, String> faculty = iDepartmentModel.getFaculty();
        assertEquals("professor", faculty.get("faculty"));
    }
}