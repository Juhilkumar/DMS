<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>


<body>
<div><jsp:include page="facultylogin.jsp"/></div>
<h3>Course Names:</h3>

<div >
    <table >
        <form action="/studentRecords" method="POST">

            <th>
                <select name="courseName">
                    <c:forEach items="${courseNames}" var="names">
                        <option value=${names}>${names}</option>
                    </c:forEach>
                </select>
            </th>
            <td><input type="submit"  value="open"/> </td>

        </form>
    </table>


</div>
</body>
</html>