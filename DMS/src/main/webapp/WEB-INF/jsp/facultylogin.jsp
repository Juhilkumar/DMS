<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Faculty Login</title>
</head>
<style>
    ul {
        float: left;
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 200px;
        height : 100%;
        background-color: #1c313b;
    }

    li a {
        display: block;
        color: white;
        padding: 8px 16px;
        text-decoration: none;

    }

    li a:hover {
        background-color: #555;
        color: white;
    }
</style>
<body>
<div class="verticalmenu">
    <ul>
      <li><a href="postAttendance">Post Attendance</a></li>
        <li><a href="/showCourses">Post Grades</a></li>
        <li><a href="/classroom">classroom schedule</a></li>
        <li><a href="timetableFaculty">Timetable</a></li>
        <li><a href = "/library">Library</a></li>
        <li><a href="/facultyPayroll">Payroll</a></li>
        <li><a href="/viewMeetings">View Meetings</a></li>
        <li><a href="/customForm">Create Custom Form</a></li>
        <li><a href="updateInformationFaculty">Update Information</a></li>
        <li><a href="/signOut">Signout</a></li>
    </ul>
</div>
</body>
</html>