<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Classroom schedule</title>
</head>
<style>
    .form-inline {
        display: flex;
        flex-flow: row wrap;
        align-items: center;
    }

    .form-inline label {
        margin: 5px 10px 5px 0;
    }
    .form-inline button {
        padding: 10px 20px;
        background-color: dodgerblue;
        border: 1px solid #ddd;
        color: white;
        cursor: pointer;
    }

    .form-inline input {
        vertical-align: middle;
        margin: 5px 10px 5px 0;
        padding: 10px;
        background-color: #fff;
        border: 1px solid #ddd;
    }

</style>
<body>
<div><jsp:include page="facultylogin.jsp"/></div>
<div class="text">
    <h3>Add classroom schedule</h3>

    <a href="/showClassroomSchedule">
        <button type="submit" class="btn btn-primary">Show Scheduled classes</button>
    </a>

    <form class="form-inline" method="POST" action="/postClassroomSchedule">
            <span>
                <label>CourseId</label>
                <input type="text" name="courseId" placeholder="Enter courseId" required>
                <br>
                <label>Class topic</label>
                <input type="text" name="classTopic" placeholder="Enter class room topic" required>
                <br>
                <label>schedule date</label>
                <input type="date" name="scheduleDate" required>
                <br>
                <label>start time </label>
                <input type="text" name="startTime" placeholder="Enter start time of classroom" required>
                <br>
                <label>end time </label>
                <input type="text" name="endTime" placeholder="Enter end time of classroom" required>
                <br>
                <button type="submit">Submit</button>
            </span>
    </form>

</div>
</body>
</html>



