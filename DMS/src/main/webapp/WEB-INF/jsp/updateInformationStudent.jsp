<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>UpdateInformation</title>
        <style>
            .updateform{
                padding-left : 210px;
                font-family : Calibri;
            }
        </style>
    </head>
    <body>
        <div><jsp:include page="studentlogin.jsp"/></div>
        <div class="updateform">
            <form action="/updateinformation" method="POST">
                <table>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="firstName" placeholder="Enter FirstName" value="${firstName}" required></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="lastName" placeholder="Enter LastName" value="${lastName}" required></td>
                    </tr>
                    <tr>
                        <td>Date of Birth:</td>

                        <td><input type="text" name="dateOfBirth" value="${birthDate}" required></td>
                    </tr>
                    <tr>
                        <td>Email ID:</td>
                        <td><input type="text" name="email" placeholder="Enter EmailID" value="${email}" required></td>
                    </tr>

                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" placeholder="Enter Password" value="${password}" required></td>
                    </tr>
                    <tr>
                        <td>Reenter Password:</td>
                        <td><input type="password" name="reenterPassword" placeholder="ReEnter Password" required></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>