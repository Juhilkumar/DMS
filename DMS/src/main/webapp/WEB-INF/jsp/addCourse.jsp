<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add Course</title>
</head>
<body>
<div><jsp:include page="adminloginpage.jsp"/></div>
<form action="ProcessAddCourse" name="addCourse">
    Course Id
    <input type="number" name="courseId"  required>
    <br><br>
    Course Name
    <input type="text" name="courseName"  required>
    <br><br>
    Faculty's Id
    <input type="number" name="facultyId"  required>
    <br><br>
    Day:
    <input type="checkbox" id="Monday" name="day" value="Monday">
    <label for="Monday"> Monday</label>
    <input type="checkbox" id="Tuesday" name="day" value="Tuesday">
    <label for="Tuesday"> Tuesday</label>
    <input type="checkbox" id="Wednesday" name="day" value="Wednesday">
    <label for="Wednesday"> Wednesday</label>
    <input type="checkbox" id="Thursday" name="day" value="Thursday">
    <label for="Thursday"> Thursday</label>
    <input type="checkbox" id="Friday" name="day" value="Friday">
    <label for="Friday"> Friday</label>
    <br><br>
    <label for="startTime">Select start time</label>
    <input type="time" name="startTime" id="startTime" min="09:00" max="18:00" required>
    <label for="endTime">Select end time</label>
    <input type="time" name="endTime" id="endTime" min="09:00" max="18:00" required>
    <input type="submit" value="submit"></td>
</form>
<br>
<br>
    Unavailable slots:
    <table border="1">
        <c:forEach items="${timetablelist}" var="timetable">
            <tr>
                <td>
                    ${timetable}
                </td>
            </tr>
        </c:forEach>
    </table>
<br>
<br>

<table border="1" cellpadding="10" style="width: 100%">
    <tr>
        <th>Course Id</th>
        <th>Course Name</th>
        <th>Remove Course</th>
    </tr>

    <c:forEach items="${list}" var="e">
        <tr>
            <td>${e.courseId}</td>
            <td>${e.courseName}</td>
            <td>
                <a href="${e.courseName}/removeCourse">
                    <button type="submit" class="btn btn-primary">Remove</button>
                </a>
            </td>
        </tr>
    </c:forEach>


</table>
</body>
</html>