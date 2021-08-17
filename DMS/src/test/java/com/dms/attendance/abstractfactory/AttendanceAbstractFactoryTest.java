package com.dms.attendance.abstractfactory;

import com.dms.attendance.*;
import com.dms.attendance.interfaces.IGetAttendanceModel;
import com.dms.attendance.interfaces.IGetCourseModel;
import com.dms.attendance.interfaces.IPostAttendanceModel;
import com.dms.attendance.interfaces.IPostCourseModel;

public abstract class AttendanceAbstractFactoryTest {
    private static AttendanceAbstractFactoryTest uniqueInstance = null;

    public abstract GetCourseDAOMock getCourseDAOMock();
    public abstract GetAttendanceDAOMock getAttendanceDAOMock();
    public abstract IGetAttendanceModel iGetAttendanceModel();
    public abstract IGetCourseModel iGetCourseModel();
    public abstract PostCourseDAOMock postCourseDAOMock();
    public abstract PostAttendanceDAOMock postAttendanceDAOMock();
    public abstract IPostAttendanceModel iPostAttendanceModel();
    public abstract IPostCourseModel iPostCourseModel();

    public static AttendanceAbstractFactoryTest instance(){
        if(null == uniqueInstance){
            uniqueInstance = new AttendanceConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}