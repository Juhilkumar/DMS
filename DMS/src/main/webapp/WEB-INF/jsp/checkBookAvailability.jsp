<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Check Book Availability</title>
</head>
<body>
<form action="checkBook" name="addBook">

    BookID
    <input type="number" name="bookId" value="${bookId}"  readonly >
    <br><br>
    Enter Book Issue Date
    <input type="text" name="issueDate" placeholder="Enter Date in dd-MM-yyyy" required>
    <br><br>

    Enter Book Return Date
    <input type="text" name="returnDate"  placeholder="Enter Date in ddd-MM-yyyy" required>
    <br><br>
    <input type="submit" name ="isBookAvailable" value="Request Book">
</form>
<div>
    <a href="/library">
        <button type="submit" class="btn btn-primary">Back to Home</button>
    </a>
</div>
<br>
<br>
</body>
</html>