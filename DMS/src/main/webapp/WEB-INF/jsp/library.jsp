<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome In Library</title>
</head>
<body>
<div>
    <a href="/login">
        <button type="submit" class="btn btn-primary">Back to Login Page</button>
    </a>
</div>

<a href="showIssuedBooks">My Books</a>

<br><br>

<form action="searchBook">
   Search Book
    <input type="text" name="searchKeyword"  required>
    <input type="submit" name ="searchBook" value="Search">
</form>

<br>
<br>

<form action="notifyBookWhenAvailable">
    Notify
    <input type="number" name="bookId"  required>
    <input type="submit" name ="Notify" value="Notify">
</form>

<br>
<br>

<table border="1" cellpadding="10" style="width: 100%">
    <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Book Author</th>
        <th>Check Availability</th>
    </tr>

    <c:forEach items="${list}" var="e">
        <tr>
            <td><c:out value="${e.bookId}"/></td>
            <td><c:out value="${e.bookName}"/></td>
            <td><c:out value="${e.bookAuthor}"/></td>
            <td>
                <a href="/checkBookAvailability/${e.bookId}">
                    <button type="submit" class="btn btn-primary">Check Availability</button>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>