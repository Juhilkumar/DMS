<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>TimeTable</title>
        <style>
            .timetable{
                padding-left : 210px;
                font-family : Calibri;
            }
        </style>
    </head>
    <body>
        <div><jsp:include page="facultylogin.jsp"/></div>
        <div class="timetable">
            <table border="1">
                <tr>
                    <th>CourseID</th>
                    <th>Schedule</th>
                </tr>
                <c:forEach items="${timetable}" var="timetableFaculty">
                    <tr>
                        <td>${timetableFaculty.key}</td>
                        <td>${timetableFaculty.value}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>