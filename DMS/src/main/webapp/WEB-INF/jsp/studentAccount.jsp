<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Student Login</title>
</head>

<body>
<div><jsp:include page="studentlogin.jsp"/></div>
<div class="text">
    <h2>Welcome, </h2>
    <h2> student account page</h2>
    <table border="1" cellpadding="2" style="width:40%">
        <tr>
            <td>
               Total Amount
            </td>
            <td>
                Billed Amount
            </td>
            <td>
                Unbilled Amount
            </td>
        </tr>
        <tr>
            <td>${studentAccount.totalAmount}</td>
            <td>${studentAccount.billedAmount}</td>
            <td>${studentAccount.unbilledAmount}</td>

        </tr>


    </table>
</div>
</body>
</html>
