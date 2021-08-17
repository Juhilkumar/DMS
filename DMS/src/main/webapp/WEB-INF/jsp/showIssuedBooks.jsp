<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Your Issued Books</title>
</head>
<body>
<div>
    <a href="/library">
        <button type="submit" class="btn btn-primary">Back to Home</button>
    </a>
</div>
<br>
<br>

<form action="returnBook" name="returnBook">
    Type Book Id You want to Return
    <input type="number" name="bookId"  required>
    <br><br>
    <input type="submit" name ="returnBookButton" value="Return">
</form>

<br>
<br>


<table border="1" cellpadding="10" style="width: 100%">
    <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Issue Date</th>
        <th>Return Date</th>
    </tr>

    <c:forEach items="${issuedBookList}" var="e">
        <tr>
            <td><c:out value="${e.bookId}"/></td>
            <td><c:out value="${e.bookName}"/></td>
            <td><c:out value="${e.issueDate}"/></td>
            <td><c:out value="${e.returnDate}"/></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>