package com.dms.course;

import com.dms.course.interfaces.ICourseDAO;
import com.dms.studentaccount.abstractfactory.StudentAccountAbstractFactory;
import connection.SqlConnectionImpl;
import connection.interfaces.ISqlConnection;
import com.dms.studentaccount.interfaces.IStudentAccountModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements ICourseDAO {
    private static final int DEFAULT_COURSE_CREDIT = 3;
    private static final float DEFAULT_COURSE_RATING= 2.5f;
    private static final int DEFAULT_COURSE_MAX_REGISTER_CAPACITY = 60;

    private final ISqlConnection connectionManager;

    StudentAccountAbstractFactory studentAccountAbstractFactory = StudentAccountAbstractFactory.instance();
    IStudentAccountModel iStudentAccountModel = studentAccountAbstractFactory.createStudentAccountModel();

    public CourseDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public Boolean isCourseIdAlreadyTaken(int courseId) throws SQLException {
        try {
            String selectQuery = "SELECT courseId FROM Course where courseId =  '" + courseId + "'";
            connectionManager.executeRead(selectQuery);
            ResultSet resultSet = connectionManager.executeResult(selectQuery);
            while (resultSet.next()) {
                int existingCourseId = resultSet.getInt("courseId");
                if (courseId == existingCourseId) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
        return false;
    }

    public Boolean addCourse(int courseId, String courseName, int facultyId , String timetable) throws SQLException {
        try {
            String insertQuery = "INSERT INTO Course(courseId, courseName, facultyId, courseCredit, courseRating, courseMaxRegisterCapacity, timetable) " +
                    "VALUES('" + courseId + "','" + courseName + "','" + facultyId + "','" + DEFAULT_COURSE_CREDIT + "','" + DEFAULT_COURSE_RATING + "','" + DEFAULT_COURSE_MAX_REGISTER_CAPACITY + "','"+timetable+"')";
            connectionManager.executeWrite(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
        return true;
    }

    public String removeCourse(String courseName) throws SQLException {
        try {
            String deleteQuery = "DELETE FROM Course where courseName = '" + courseName + "'";
            connectionManager.executeWrite(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return courseName;
    }

    public ArrayList<Course> getCourses() throws SQLException{
        Course course;
        ArrayList<Course> coursesList = new ArrayList<>();
        try {
            String getCourses = "SELECT * FROM Course";
            connectionManager.executeRead(getCourses);
            ResultSet resultSet = connectionManager.executeResult(getCourses);
            while (resultSet.next()) {
                course = new Course();
                course.setCourseId(resultSet.getInt("courseId"));
                course.setCourseName(resultSet.getString("courseName"));
                coursesList.add(course);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            connectionManager.closeConnection();
        }
        return  coursesList;
    }

    public boolean registerCourse(int courseId, String userName, int semester) throws SQLException{

        int studentId = 0;
        int courseIdRegistered = 0;
        boolean registerdSuccessfully =false;

        try {

            String studentIdQuery = "SELECT studentId FROM Student WHERE userName = '" + userName + "'";
            connectionManager.executeRead(studentIdQuery);
            ResultSet resultSet = connectionManager.executeResult(studentIdQuery);
            while (resultSet.next()) {
                studentId = resultSet.getInt("studentId");
            }

            String checkIfUserRegisteredCourseAlready = "SELECT studentId, courseId FROM CourseRegistrationDetails WHERE courseId = " + courseId + " AND studentId =" + studentId;
            resultSet = connectionManager.executeResult(checkIfUserRegisteredCourseAlready);

            while (resultSet.next()) {
                courseIdRegistered = resultSet.getInt("courseId");
            }

            String decreaseCourseSlot = "UPDATE Course SET courseAvailableSlots = courseAvailableSlots-1 WHERE courseId =" + courseId + " AND courseAVailableSlots > 0";

            if(courseId != courseIdRegistered){
                String registrationQuery = "INSERT INTO CourseRegistrationDetails(courseId, studentId, semester) VALUES(" + courseId + "," + studentId + "," + semester + ")";
                connectionManager.executeWrite(registrationQuery);
                connectionManager.executeWrite(decreaseCourseSlot);
                iStudentAccountModel.deductMoney(studentId);
                registerdSuccessfully = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return  registerdSuccessfully;
    }

    public boolean withdrawCourse(int courseId, String userName) throws SQLException{
        boolean withdrawSuccess = false;
        int studentId = 0;
        int iscourseIdRegistered=0;
        try {
            String studentIdQuery = "SELECT studentID FROM Student where userName = '" + userName + "'";
            connectionManager.executeRead(studentIdQuery);
            ResultSet resultSet = connectionManager.executeResult(studentIdQuery);
            while (resultSet.next()) {
                studentId = resultSet.getInt("studentId");
            }

            String checkIfUserRegisteredCourseAlready = "SELECT studentId, courseId FROM CourseRegistrationDetails WHERE courseId = " + courseId + " AND studentId =" + studentId;
            resultSet = connectionManager.executeResult(checkIfUserRegisteredCourseAlready);

            while (resultSet.next()) {
                iscourseIdRegistered = resultSet.getInt("courseId");
            }

            if(iscourseIdRegistered>0){
                String withdrawCourseQuery = "DELETE FROM CourseRegistrationDetails WHERE courseId =" + courseId + " AND studentId = " + studentId ;
                String increaseCourseSlot = "UPDATE Course SET courseAvailableSlots = courseAvailableSlots+1 WHERE courseId =" + courseId + " AND courseAVailableSlots > 0";
                withdrawSuccess = connectionManager.executeWrite(withdrawCourseQuery);
                connectionManager.executeWrite(increaseCourseSlot);
                iStudentAccountModel.depositMoney(studentId);
            }else{
                withdrawSuccess=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }

        return withdrawSuccess;
    }

    public List<String> retrieveTimetable(String userName) throws SQLException{
        List<String> timetable = new ArrayList<>();
        try {
            String studentIdQuery = "SELECT timetable FROM Course;";
            connectionManager.executeRead(studentIdQuery);
            ResultSet resultSet = connectionManager.executeResult(studentIdQuery);
            while (resultSet.next()) {
                timetable.add(resultSet.getString(1));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return timetable;
    }
}