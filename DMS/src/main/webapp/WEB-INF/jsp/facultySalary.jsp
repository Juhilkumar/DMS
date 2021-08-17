<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>


<body>
<div><jsp:include page="adminloginpage.jsp"/></div>
<h3>Generate faculty salaries</h3>
<form action="/updateFacultySalary" method="POST">
    <table>
        <tr>
            <th>
                Faculty ID:
            </th>
            <td>
                Salary(CAD):
            </td>
            <td>
                Month:
            </td>
            <td>
                Year(yyyy):
            </td>
        </tr>


            <tr>
                <td>
                    <select name="facultyId" required>
                        <c:forEach items="${facultyDetails}" var="faculty" >
                            <option value=${faculty.key}>${faculty.key}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="text" name="salary" required> </td>
                <td>
                    <select name="month" required>
                        <option value=1>1</option>
                        <option value=2>2</option>
                        <option value=3>3</option>
                        <option value=4>4</option>
                        <option value=5>5</option>
                        <option value=6>6</option>
                        <option value=7>7</option>
                        <option value=8>8</option>
                        <option value=9>9</option>
                        <option value=10>10</option>
                        <option value=11>11</option>
                        <option value=12>12</option>
                    </select>
                </td>
                <td><input type="text" name="year" required> </td>
                <td><input type="submit" value="submit" /></td>
            </tr>
    </table>
</form>

</body>
</html>