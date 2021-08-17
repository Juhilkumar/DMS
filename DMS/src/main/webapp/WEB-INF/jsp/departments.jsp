<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<div><jsp:include page="navigation.jsp"/></div>
<div class="deptdetails">
    <h3>Courses Offered:</h3>
    <table>
        <tr>
            <th>
                Course Name
            </th>
        </tr>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course}</td>
            </tr>
        </c:forEach>
    </table>

    <h3>Faculty:</h3>
    <table>
        <tr>
            <th>
                Faculty Name
            </th>
            <th>
                Designation
            </th>
        </tr>
        <c:forEach items="${facultyList}" var="faculty">
            <tr>
                <td>
                        ${faculty.key}
                </td>
                <td>
                        ${faculty.value}
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>