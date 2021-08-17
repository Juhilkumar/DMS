<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Time Table</title>
        <style>
            .timetable{
                padding-left : 210px;
                font-family : Calibri;
            }
        </style>
    </head>
    <body>
        <div><jsp:include page="studentlogin.jsp"/></div>
            <div class="timetable">
                    <table border="1">
                        <tr>
                            <th>CourseID</th>
                            <th>Schedule</th>
                        </tr>
                        <c:forEach items="${timetable}" var="timetableStudent">
                            <tr>
                                <td>${timetableStudent.key}</td>
                                <td>${timetableStudent.value}</td>
                            </tr>
                        </c:forEach>
                    </table>
            </div>
        </body>
</html>