package com.dms.classroom;

import com.dms.classroom.interfaces.IClassroomDAO;
import com.dms.classroom.interfaces.IClassroomModel;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ClassroomModel implements IClassroomModel {
    private boolean postClassroom;
    private int courseId;
    private String classTopic;
    private Date scheduleDate;
    private String startTime;
    private String endTime;
    private IClassroomDAO classroomDAO;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getClassTopic() {
        return classTopic;
    }

    public void setClassTopic(String classTopic) {
        this.classTopic = classTopic;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public ClassroomModel(){ }

    public ClassroomModel(IClassroomDAO classroomDAO){
        this.classroomDAO = classroomDAO;
    }

    public boolean postClassroomSchedule(String userName, int courseId, String classTopic, Date scheduleDate, String startTime, String endTime) throws SQLException {
        postClassroom = classroomDAO.postClassroomSchedule(userName,courseId,classTopic,scheduleDate,startTime,endTime);
        return postClassroom;
    };

    public List<ClassroomModel> showClassroomSchedule(String userName) throws SQLException{
        List<ClassroomModel> classroomSchedule;
        classroomSchedule = classroomDAO.getClassroom(userName);
        return classroomSchedule;
    }
}
