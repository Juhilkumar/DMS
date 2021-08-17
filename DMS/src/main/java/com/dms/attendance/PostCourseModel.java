package com.dms.attendance;

import com.dms.attendance.interfaces.IPostCourseDAO;
import com.dms.attendance.interfaces.IPostCourseModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostCourseModel implements IPostCourseModel {
    private final IPostCourseDAO iPostCourseDao;
    public PostCourseModel(IPostCourseDAO postCourseDao) {
        this.iPostCourseDao = postCourseDao;
    }

    public List<Integer> getCourseIDForFaculty(String userName) throws SQLException{
        List<Integer> courseId = new ArrayList<>();
        courseId=iPostCourseDao.getCourseIDForFaculty(userName);
        return courseId;
    }
}