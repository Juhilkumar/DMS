<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" errorPage="error.jsp"%>
<html>
<head>
    <title>
        Sign Up
    </title>


</head>
<body class="body">

<p class="title">SignUp Page</p>

<form action="processForm" name="signUpForm">

    <input type="radio" name="role" value="student"/>Student
    <input type="radio" name="role" value="faculty"/>Faculty

    <br><br>

    User Name
    <input type="text" name="username" placeholder="Enter UserID" required>

    <br><br>

    Password
    <input type="password" name="password" placeholder="Enter Password" required>

    <br><br>

    Email
    <input type="text" name="email" placeholder="Enter EmailID" required>

    <br><br>

    First Name
    <input type="text" name="firstName" placeholder="Enter First name" required>

    <br><br>

    Last Name
    <input type="text" name="lastName" placeholder="Enter Last name" required>

    <br><br>

    DOB
    <input type="text" name="dob" placeholder="Enter Date in dd-MM-yyyy format">

    <br><br>

    Security Question : Which is your favourite car

    <br><br>

    Security Answer
    <input type="text" name="securityAnswer" placeholder="Enter the security answer" required>

    <br><br>

    <input type="submit" value="submit">
</form>
</body>
</html>