<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div><jsp:include page="facultylogin.jsp"/></div>
<h3>select month and year to get the details of salary:</h3>
<div class="salaryDetails">
    <form action="/retrieveSalaryInfo" method="post">
        <table>
            <tr>
                <td>
                    <select name="month">
                        <option value="January" >January</option>
                        <option value="February" >February</option>
                        <option value="March" >March</option>
                        <option value="April" >April</option>
                        <option value="May" >May</option>
                        <option value="June" >June</option>
                        <option value="July" >July</option>
                        <option value="August" >August</option>
                        <option value="September" >September</option>
                        <option value="October" >October</option>
                        <option value="November" >November</option>
                        <option value="December" >December</option>
                    </select>
                </td>

                <td>
                    <select name="year">
                        <option value=2021 >2021</option>
                        <option value=2022 >2022</option>
                        <option value=2023 >2023</option>
                        <option value=2024 >2024</option>
                        <option value=2025 >2025</option>
                        <option value=2026 >2026</option>
                        <option value=2027 >2027</option>
                        <option value=2028 >2028</option>
                        <option value=2029 >2029</option>
                        <option value=2030 >2030</option>
                    </select>

                </td>
                <td>
                    <input type="submit" value="submit" formtarget="_self">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
