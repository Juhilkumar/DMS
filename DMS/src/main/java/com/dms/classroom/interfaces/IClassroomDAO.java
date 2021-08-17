package com.dms.classroom.interfaces;

import com.dms.classroom.ClassroomModel;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IClassroomDAO {
    boolean postClassroomSchedule(String userName, int courseId, String classTopic, Date scheduleDate, String startTime, String endTime) throws SQLException;
    List<ClassroomModel> getClassroom(String userName) throws SQLException;
}
