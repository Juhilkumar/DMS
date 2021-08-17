<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>course rating</title>

</head>
<div><jsp:include page="studentlogin.jsp"/></div>
<div class="text">
    <h2> course rating page</h2>

    <table>
        <tr>
            <td>
                course Id
            </td>
            <td>
                course Name
            </td>
            <td>
                Rate course
            </td>
        </tr>

        <c:forEach items="${courseList}" var="course">
            <tr>
                <td><c:out value="${course.courseId}"/></td>
                <td><c:out value="${course.courseName}"/></td>
                <td>
                    <form method="POST" action="/postRating/${course.courseId}">
                        <fieldset>
                            <span>
                              <input type="radio" id="rating-5" name="rating" value="5" />
                              <label for="rating-5">5</label>
                              <input type="radio" id="rating-4" name="rating" value="4" checked="checked" />
                              <label for="rating-4">4</label>
                              <input type="radio" id="rating-3" name="rating" value="3" />
                              <label for="rating-3">3</label>
                              <input type="radio" id="rating-2" name="rating" value="2" />
                              <label for="rating-2">2</label>
                              <input type="radio" id="rating-1" name="rating" value="1" />
                              <label for="rating-1">1</label>
                              <input type="submit" value="submit">
                            </span>
                        </fieldset>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
