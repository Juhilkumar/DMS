<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Post Attendance</title>
        <style>
            .attendance{
                padding-left : 210px;
                font-family : Calibri;
            }
        </style>
    </head>
    <body>
        <div><jsp:include page="facultylogin.jsp"/></div>
        <div class="attendance">
            <form action="setattendance" method="post">
                <table>
                    <tr>
                        <td>
                            <select name="course_ID" required>
                                <c:forEach items="${courseID}" var="course_ID">
                                    <option value="${course_ID}" >${course_ID}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name="student_Id" placeholder="enter student ID" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select name="attendance_status" required>
                                    <option value="present">Present</option>
                                    <option value="absent">Absent</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="submit">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>