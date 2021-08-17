<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>course registration</title>
</head>
<style>

    td {
        padding: 5px;
    }
    table {
        border-spacing: 5px;
        border-collapse: separate;
        margin-bottom: 20px;
    }
</style>

<body>
<div><jsp:include page="studentlogin.jsp"/></div>
<div class="text">
    <h2> course registration page</h2>

    <table  class="registration" >
        <tr>
            <td>
                course Id
            </td>
            <td>
                course Name
            </td>
            <td>
                semester
            </td>

        </tr>
        <c:forEach items="${courseList}" var="course">
            <tr>
                <td><c:out value="${course.courseId}"/></td>
                <td><c:out value="${course.courseName}"/></td>
                <form action="/registerCourse/${course.courseId}">
                    <td>
                        <select class="semester"id="semester" name="semester">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                        <button type="submit">Register</button>
                    </td>

                </form>
            </tr>
        </c:forEach>
    </table>

    <table>
            <tr>
                <td>
                    course Id
                </td>
                <td>
                    course Name
                </td>
            </tr>
            <c:forEach items="${courseList}" var="course">
                <tr>
                    <td><c:out value="${course.courseId}"/></td>
                    <td><c:out value="${course.courseName}"/></td>

                    <td>
                        <a href="/withdrawCourse/${course.courseId}">
                            <button type="submit" class="btn btn-primary">withdraw</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
    </table>

</div>
</body>
</html>