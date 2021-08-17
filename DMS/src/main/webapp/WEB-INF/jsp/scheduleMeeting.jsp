<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div><jsp:include page="studentlogin.jsp"/></div>
<h3>${bookingStatus}</h3><br>

<form action="/scheduleMeeting" >
    <table>
        <tr>
            <td><input type="submit" value="Back to schedule slot"></td>
        </tr>

    </table>
</form>

</body>
</html>