<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>CustomForm Success</title>
</head>
<body>
<jsp:include page="facultylogin.jsp"/>
You have successfully created ${param.formName} form
<div>
    <table border="1" cellpadding="10" style="width: 100%">
        <tr>
            <th>Question Description</th>
            <th>questionType</th>
            <th>optionValue1</th>
            <th>optionValue2</th>
            <th>optionValue3</th>
            <th>optionValue4</th>
        </tr>

        <c:forEach items="${list}" var="e">
            <tr>
                <td><c:out value="${e.questionDescription}"/></td>
                <td><c:out value="${e.questionType}"/></td>
                <td><c:out value="${e.optionValue1}"/></td>
                <td><c:out value="${e.optionValue2}"/></td>
                <td><c:out value="${e.optionValue3}"/></td>
                <td><c:out value="${e.optionValue4}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>