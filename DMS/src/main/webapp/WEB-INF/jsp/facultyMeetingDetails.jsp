<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>


<body>
<div><jsp:include page="studentlogin.jsp"/></div>
<h3>Schedule Meeting:</h3>
<div >

    <table>
        <tr>
        <th>Course Name:</th>
        <th>Faculty ID:</th>
        <th> Select Date:</th>
        </tr>
        <form action="/CheckSlotAvailabilty"  method="post">
            <tr>

                <td>
                    <select name="courseName">
                        <c:forEach items="${detailsList}" var="meetingInfo">
                            <option value=${meetingInfo.value.get(1)}>${meetingInfo.value.get(1)}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="facultyID">
                        <c:forEach items="${detailsList}" var="meetingInfo">
                            <option value=${meetingInfo.value.get(2)}>${meetingInfo.value.get(2)}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="date" name="appointmentDate"  ></td>
                <td>
                    <select name="slot">
                        <option value="3:00 PM" >3:00 PM</option>
                        <option value="4:00 PM" >4:00 PM</option>
                    </select>
                </td>
                <td><input type="submit" value="Book Slot"/></td>
            </tr>
        </form>
    </table>



</div>
</body>
</html>