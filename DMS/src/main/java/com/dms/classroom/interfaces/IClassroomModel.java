package com.dms.classroom.interfaces;

import com.dms.classroom.ClassroomModel;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IClassroomModel {
    boolean postClassroomSchedule(String userName, int courseId, String classTopic, Date scheduleDate, String startTime, String endTime) throws SQLException;
    List<ClassroomModel> showClassroomSchedule(String userName) throws SQLException;
}
