<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Fill form response</title>
</head>
<body>
<jsp:include page="studentlogin.jsp"/>
Please fill the form
<form action="/processFormResponse" method="post">

        <table cellpadding="10" border="1px">
            <input type="hidden" name="q_no" value="${list.size()}"/>
            <c:set var="questionNo" value="0" scope="page"/>
            <c:forEach items="${list}" var="e">
            <div>
                <c:set var="questionNo" value="${questionNo + 1}" scope="page"/>
                <tr>
                    <input type="hidden" name="questionId_${questionNo}" value="${e.questionId}"/>
                    <c:if test="${e.questionType == '1'}">
                        <td name="QuestionId_${e.questionId}">
                            <c:out value="${e.questionDescription}"/>
                        </td>
                        <td>
                            <input type="number" required name="answerForQuestionId_${e.questionId}">
                        </td>

                    </c:if>
                    <c:if test="${e.questionType == '2'}">
                        <td name="QuestionId_${e.questionId}">
                            <c:out value="${e.questionDescription}"/>
                        </td>
                        <td>
                            <input type="radio" name="answerForQuestionId_${e.questionId}" value="${e.optionValue1}">
                            <c:out value="${e.optionValue1}"/>
                        </td>
                        <td>
                            <input type="radio" name="answerForQuestionId_${e.questionId}" value="${e.optionValue2}">
                            <c:out value="${e.optionValue2}"/>
                        </td>
                        <td>
                            <input type="radio" name="answerForQuestionId_${e.questionId}" value="${e.optionValue3}">
                            <c:out value="${e.optionValue3}"/>
                        </td>
                        <td>
                            <input type="radio" name="answerForQuestionId_${e.questionId}" value="${e.optionValue4}">
                            <c:out value="${e.optionValue4}"/>
                        </td>
                    </c:if>
                    <c:if test="${e.questionType == '3'}">
                        <td name="QuestionId_${e.questionId}">
                            <c:out value="${e.questionDescription}"/>
                        </td>
                        <td>
                            <input type="text" name="answerForQuestionId_${e.questionId}" required>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
    <input type="submit" required>
</form>
</body>
</html>