<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Forgot Password</title>
    </head>
    <body>
        <div><jsp:include page="navigation.jsp"/></div>
        <div>
            <table>
                <form action="resetPassword" method="post">
                    <tr>
                        <td>
                            Username:
                        </td>
                        <td>
                            <input type="text" name="username" placeholder="enter username" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Security Question:
                        </td>
                        <td>
                            <input type="text" name="securityQuestion" value="What is your favourite car?">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Security Answer:
                        </td>
                        <td>
                            <input type="text" name="securityAnswer" placeholder="enter answer" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            email ID:
                        </td>
                        <td>
                            <input type="text" name="emailID" placeholder="enter email address" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Password:
                        </td>
                        <td>
                            <input type="password" name="password" placeholder="enter password" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Reenter Password:
                        </td>
                        <td>
                            <input type="password" name="reenterPassword" placeholder="reenter password" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit">
                        </td>
                    </tr>
                </form>
            </table>
        </div>
    </body>
</html>
