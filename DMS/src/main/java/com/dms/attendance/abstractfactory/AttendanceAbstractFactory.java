package com.dms.attendance.abstractfactory;

import com.dms.attendance.GetAttendanceDAO;
import com.dms.attendance.GetCourseDAO;
import com.dms.attendance.PostAttendanceDAO;
import com.dms.attendance.PostCourseDAO;
import com.dms.attendance.interfaces.IGetAttendanceModel;
import com.dms.attendance.interfaces.IGetCourseModel;
import com.dms.attendance.interfaces.IPostAttendanceModel;
import com.dms.attendance.interfaces.IPostCourseModel;

public abstract class AttendanceAbstractFactory {
    private static AttendanceAbstractFactory uniqueInstance = null;

    public abstract GetCourseDAO getCourseDAO();
    public abstract GetAttendanceDAO getAttendanceDAO();
    public abstract IGetAttendanceModel iGetAttendanceModel();
    public abstract IGetCourseModel iGetCourseModel();
    public abstract PostCourseDAO postCourseDAO();
    public abstract PostAttendanceDAO postAttendanceDAO();
    public abstract IPostAttendanceModel iPostAttendanceModel();
    public abstract IPostCourseModel iPostCourseModel();

    public static AttendanceAbstractFactory instance(){
        if(null == uniqueInstance){
            uniqueInstance = new AttendanceConcreteFactory();
        }
        return uniqueInstance;
    }
}