<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>


<body>
<div><jsp:include page="facultylogin.jsp"/></div>
<h3>Check scheduled meeting information:</h3>
<div >

    <table>

        <form action="/checkScheduleOfMeetings"  method="post">
            <tr>
                <td><input type="date" name="checkDate" required></td>
                <td><input type="submit" value="Show meetings for the selected date"/></td>
            </tr>

        </form>
    </table>
</div>
</body>
</html>