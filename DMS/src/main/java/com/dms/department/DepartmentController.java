package com.dms.department;

import com.dms.department.abstractfactory.DepartmentAbstractFactory;
import com.dms.department.interfaces.IDepartmentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class DepartmentController {
    DepartmentAbstractFactory departmentAbstractFactory = DepartmentAbstractFactory.instance();
    IDepartmentModel departmentModel = departmentAbstractFactory.iDepartmentModel();
    @RequestMapping(value="departments")
    public String showDepartmentPage(ModelMap model) throws SQLException {
        List<String> courses = departmentModel.getCourses();
        Map<String,String> faculty = departmentModel.getFaculty();
        model.addAttribute("courses",courses);
        model.addAttribute("facultyList",faculty);
        return "departments";
     }
}