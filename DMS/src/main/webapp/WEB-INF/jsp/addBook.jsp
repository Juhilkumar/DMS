<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome Admin</title>
</head>
<body>
<div><jsp:include page="adminloginpage.jsp"/></div>
<form action="ProcessAddBook" name="addBook">
    Book Name
    <input type="text" name="bookName"  required>
    <br><br>
    Book Author
    <input type="text" name="bookAuthor"  required>
    <br><br>
    Quantity of the book
    <input type="number" name="bookQuantity"  required>
    <br><br>

    <input type="submit" value="submit"></td>


</form>

<br>
<br>

<table border="1" cellpadding="10" style="width: 100%">
    <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Book Author</th>
        <th>Remove Book</th>
    </tr>

    <c:forEach items="${list}" var="e">
        <tr>
            <td>${e.bookId}</td>
            <td>${e.bookName}</td>
            <td>${e.bookAuthor}</td>
            <td>
                <a href="${e.bookName}/removeBook">
                    <button type="submit" class="btn btn-primary">Remove</button>
                </a>
            </td>
        </tr>
    </c:forEach>


</table>
</body>
</html>