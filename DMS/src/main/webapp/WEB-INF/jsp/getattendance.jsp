<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Attendance</title>
        <style>
            .attendance{
                padding-left : 210px;
                font-family : Calibri;
            }
        </style>
    </head>
    <body>
        <div><jsp:include page="studentlogin.jsp"/></div>
        <div class="attendance">
            <form action="retrieveattendance" method="post">
                <table>
                    <tr>
                        <td>
                            <select name="course_ID">
                                <c:forEach items="${courseID}" var="course_ID">
                                    <option value="${course_ID}" >${course_ID}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input type="submit" value="submit" formtarget="_self">
                        </td>
                    </tr>
                </table>
            </form>

            Attendance(%):<input type="text" placeholder="result" name="attendance" value="${attendance}">
        </div>
</body>
</html>