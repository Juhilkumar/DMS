<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome Admin</title>
</head>

<body>
<div><jsp:include page="adminloginpage.jsp"/></div>
<div>
    Hello Admin
    <table border="1" cellpadding="10" style="width: 100%">
        <tr>
            <th>UserName</th>
            <th>Name</th>
            <th>Role</th>
            <th>Status</th>
            <th>Approve</th>
            <th>Remove</th>
        </tr>

        <c:forEach items="${list}" var="e">
            <tr>
                <td><c:out value="${e.username}"/></td>
                <td><c:out value="${e.firstName}"/></td>
                <td><c:out value="${e.role}"/></td>
                <td><c:out value="${e.status}"/></td>
                <td>
                    <a href="${e.username}/approve">
                        <button type="submit" class="btn btn-primary">Approve</button>
                    </a>
                </td>
                <td>
                    <a href="${e.username}/remove">
                        <button type="submit" class="btn btn-primary">Remove</button>
                    </a>
                </td>
            </tr>
        </c:forEach>


    </table>
</div>
</body>
</html>