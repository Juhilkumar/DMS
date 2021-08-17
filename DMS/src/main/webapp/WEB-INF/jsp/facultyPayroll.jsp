<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>


<body>
<div><jsp:include page="facultylogin.jsp"/></div>
<h3>Faculty Salary Info:</h3>
<div >
    <form action="/facultyPayroll" method="get">
    <table>
        <c:forEach items="${salaryList}" var="salary">
            <tr>
            <td><p>"Salary of ${salary.value.get(1)} CAD got credited in your account for month ${salary.value.get(2)} of ${salary.value.get(3)} year" </p></td>
            </tr>
        </c:forEach>

        <tr><td><h3>${notUpdated}</h3><br></td></tr>

        <tr>
           <td> <input type="submit" value="Back to check salary"></td>
        </tr>

    </table>
    </form>

</div>
</body>
</html>