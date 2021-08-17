package com.dms.classroom;

import com.dms.classroom.abstractfactory.ClassroomAbstractFactory;
import com.dms.classroom.interfaces.IClassroomDAO;
import com.dms.classroom.interfaces.IClassroomModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassroomDAOMock implements IClassroomDAO {
    private static final String USER_NAME = "Moksh";
    private static final String CLASS_TOPIC = "TDD";
    private static final String START_TIME = "12:00 PM";
    private static final String END_TIME = "1:00 PM";
    private static int COURSE_ID = 5000;

    Date today = new java.sql.Date(System.currentTimeMillis());

    public boolean postClassroomSchedule(String userName, int courseId, String classTopic, Date scheduleDate, String startTime, String endTime) throws SQLException {
        boolean postClassroom = false;
        if (courseId == COURSE_ID && userName == USER_NAME && classTopic == CLASS_TOPIC && scheduleDate.equals(today) && startTime == START_TIME && endTime == END_TIME) {
            postClassroom = true;
        }
        return postClassroom;
    }

    public List<ClassroomModel> getClassroom(String userName) throws SQLException {
        List<ClassroomModel> classroomsSchedule = new ArrayList<>();
        if (userName.equals(USER_NAME)) {
            ClassroomModel classroomModel = new ClassroomModel();
            classroomModel.setCourseId(COURSE_ID);
            classroomModel.setClassTopic(CLASS_TOPIC);
            classroomModel.setStartTime(START_TIME);
            classroomModel.setEndTime(END_TIME);
            classroomsSchedule.add(classroomModel);
        }
        return classroomsSchedule;
    }
}
