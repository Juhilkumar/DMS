package com.dms.attendance.abstractfactory;

import com.dms.attendance.*;
import com.dms.attendance.interfaces.IGetAttendanceModel;
import com.dms.attendance.interfaces.IGetCourseModel;
import com.dms.attendance.interfaces.IPostAttendanceModel;
import com.dms.attendance.interfaces.IPostCourseModel;

public class AttendanceConcreteFactoryTest extends AttendanceAbstractFactoryTest{
    public GetCourseDAOMock getCourseDAOMock() {
        return new GetCourseDAOMock();
    }

    public GetAttendanceDAOMock getAttendanceDAOMock() {
        return new GetAttendanceDAOMock();
    }

    public IGetAttendanceModel iGetAttendanceModel() {
        return new GetAttendanceModel(getAttendanceDAOMock());
    }

    public IGetCourseModel iGetCourseModel() {
        return new GetCourseModel(getCourseDAOMock());
    }

    public PostCourseDAOMock postCourseDAOMock() {
        return new PostCourseDAOMock();
    }

    public PostAttendanceDAOMock postAttendanceDAOMock() {
        return new PostAttendanceDAOMock();
    }

    public IPostAttendanceModel iPostAttendanceModel() {
        return new PostAttendanceModel(postAttendanceDAOMock());
    }

    public IPostCourseModel iPostCourseModel() {
        return new PostCourseModel(postCourseDAOMock());
    }
}