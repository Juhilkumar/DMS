<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html >
<head>
    <title>
        LOGIN FORM
    </title>
    <style>
        *{
            margin: 0px;
            padding: 0px;
        }
        le{
            position: absolute;
            top:10%;
            left:30%;
            border-spacing: 15px;
        }

        input[type=text] {
            background: transparent;
            border: none;
            border-bottom: 1px solid #000000;
            padding: 10px;
        }
        input[type=password] {
            background: transparent;
            border: none;
            border-bottom: 1px solid #000000;
            padding: 10px;
        }
    </style>

</head>
<body class="body">
<div><jsp:include page="navigation.jsp"/></div>

<form action="/accountlogin" method="POST">
    <table class="table" >
        <tr class="UserID">
            <th>UserName</th>
            <td>
                <input type="text" name="UserID" placeholder="Enter UserName" required>
            </td>
        </tr>

        <tr class="password">
            <th>Password</th>
            <td>
                <input type="password" name="password" placeholder="Enter Password" required>
            </td>

        </tr>
        <tr  class = "captcha">
            <th>Captcha</th>
            <td>
                <input type="text" name="captchaInput" value="${captchainput}">
            </td>
        </tr>
        <tr>
            <th> Enter Captcha</th>
            <td>
                <input type="text" name="captchaOutput" placeholder="Enter captcha" required>
            </td>
        </tr>


        <tr>
            <td><input type="submit" value="submit"></td>
            <td><a href="signUpForm">SignUp</a></td>

        </tr>
        <tr>
            <td><a href="forgotpassword">Forgot Password?</a> </td>
        </tr>

    </table>
</form>
</body>
</html>