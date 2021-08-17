<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Admin Login</title>
</head>
<style>
    .container {
        display: flex;
        align-items: center;
        justify-content: center
    }

    ul {
        float: left;
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 200px;
        height: 100%;
        background-color: #1c313b;
    }

    li a {
        display: block;
        color: white;
        padding: 8px 16px;
        text-decoration: none;

    }

    /* Change the link color on hover */
    li a:hover {
        background-color: #555;
        color: white;
    }

    .text {
        padding-left: 210px;
    }
</style>
<body>
<div class="verticalmenu">
    <ul>
        <li>
            <a href="/admin">Admin Home</a>
        </li>
        <li>
            <a href="/addBook">Add Books</a>
        </li>
        <li>
            <a href="/addCourse">Add Course</a>
        </li>
        <li>
            <a href="/facultySalary">GenarateSalaries</a>
        </li>
        <li><a href="/signOut">Signout</a></li>
    </ul>
</div>
<div class="text">
    <h2>Welcome, </h2>
</div>
</body>
</html>
