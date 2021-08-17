package com.dms.attendance;

import com.dms.attendance.interfaces.IGetCourseDAO;
import com.dms.attendance.interfaces.IGetCourseModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetCourseModel implements IGetCourseModel {
    private final IGetCourseDAO iGetCourseDao;

    public GetCourseModel(IGetCourseDAO iGetCourseDao) {
        this.iGetCourseDao = iGetCourseDao;
    }

    public List<Integer> getCourseID(String userName) throws SQLException {
        List<Integer> courseId = new ArrayList<>();
        courseId=iGetCourseDao.getCourseID(userName);
        return courseId;
    }
}