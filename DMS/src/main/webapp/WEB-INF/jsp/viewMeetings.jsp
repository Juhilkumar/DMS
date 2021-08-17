<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>

<body>
<div><jsp:include page="facultylogin.jsp"/></div>
<h3>Scheduled Meetings Information:</h3>
<div >
    <form action="/viewMeetings" method="get">
    <table>
        <c:forEach items="${meetingsList}" var="meetings">
            <tr>
                <td><p>"Student ID: ${meetings.value.get(3)}, booked ${meetings.value.get(2)} slot
                        of date ${meetings.value.get(1)}" </p></td>
            </tr>
        </c:forEach>

        <tr><td><h3>${NoMeetings}</h3><br></td></tr>
        <tr>
            <td> <input type="submit" value="Back to check meetings"></td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>