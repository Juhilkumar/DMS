<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        .table{
            position: absolute;
            top:10%;
            left:30%;
            border-spacing: 15px;
            border-color: #1c313b;
        }
    </style>

</head>


<body>
<div><jsp:include page="facultylogin.jsp"/></div>
<h3>Student Names:</h3>

<div >

    <form action="/postGradesToStudents" method="POST">
    <table>
    <tr>
        <th>
            Student ID:
        </th>
        <td>
            course ID:
        </td>
        <td>
            Marks:
        </td>
    </tr>
        <tr>
            <td>
            <select name="studentId">
                <c:forEach items="${Studentdetails}" var="student">
           <option value=${student.key}>${student.key}</option>
            </c:forEach>
            </select>
            </td>
            <td>
                <select name="courseId">
                    <c:forEach items="${Studentdetails}" var="student">
           <option value=${student.value.get(0)}>${student.value.get(0)}</option>
            </c:forEach>
            </select>
            </td>
            <td><input type="text" name="studentGrade"></td>
            <td><input type="submit" value="submit" /></td>

        </tr>
        </table>
    </form>
    
</div>

</body>
</html>