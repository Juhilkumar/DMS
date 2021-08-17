<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<div><jsp:include page="studentlogin.jsp"/></div>
<h3>Student Grade History</h3>
<div >
    <table>
        <tr>
            <th>
                Course ID:
            </th>
            <td>
                Grade:
            </td>
        </tr>
        <c:forEach items="${Studentgrades}" var="grade">
            <tr>
                <th><h4>${grade.key}</h4></th>
                <td><h4>${grade.value}</h4> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>