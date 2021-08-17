package com.dms.attendance.abstractfactory;

import com.dms.attendance.*;
import com.dms.attendance.interfaces.IGetAttendanceModel;
import com.dms.attendance.interfaces.IGetCourseModel;
import com.dms.attendance.interfaces.IPostAttendanceModel;
import com.dms.attendance.interfaces.IPostCourseModel;

public class AttendanceConcreteFactory extends AttendanceAbstractFactory {
    public GetCourseDAO getCourseDAO() {
        return new GetCourseDAO();
    }

    public GetAttendanceDAO getAttendanceDAO() {
        return new GetAttendanceDAO();
    }

    public IGetAttendanceModel iGetAttendanceModel() {
        return new GetAttendanceModel(getAttendanceDAO());
    }

    public IGetCourseModel iGetCourseModel() {
        return new GetCourseModel(getCourseDAO());
    }

    public PostCourseDAO postCourseDAO() {
        return new PostCourseDAO();
    }

    public PostAttendanceDAO postAttendanceDAO() {
        return new PostAttendanceDAO();
    }

    public IPostAttendanceModel iPostAttendanceModel() {
        return new PostAttendanceModel(postAttendanceDAO());
    }

    public IPostCourseModel iPostCourseModel() {
        return new PostCourseModel(postCourseDAO());
    }

}