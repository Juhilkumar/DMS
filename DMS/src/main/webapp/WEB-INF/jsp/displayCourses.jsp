<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div><jsp:include page="studentlogin.jsp"/></div>
<h3>Registered Course Names:</h3>
<div >
    <table>
        <form action="/retrieveGrade" method="POST">

            <th>
                <select name="selectedCourse" required>
                    <c:forEach items="${studentCoursesList}" var="courses">
                        <option value=${courses}>${courses}</option>
                    </c:forEach>
                </select>
            </th>
            <td><input type="submit"  value="Check Grade"/> </td>
        </form>
    </table>
</div>
<div>
    <table>
        <form action="/getCgpa" method="POST">
            <h3>Check CGPA by selecting the semester:</h3>
            <tr>
                CGPA:
                <td>
                    <select name="semester" required>
                        <option value=1>1</option>
                        <option value=2>2</option>
                        <option value=3>3</option>
                        <option value=4>4</option>
                    </select>
                </td>
                <td><input type="submit"  value="Check CGPA"/> </td>
            </tr>

        </form>

    </table>
</div>


</body>
</html>