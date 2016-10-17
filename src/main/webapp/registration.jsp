<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 17.10.2016
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<center>
    <h1> Registration form</h1>
    <form action="/registration" method="post">
    <table>
        <tr>
            <td>Login: </td>
            <c:choose>
                <c:when test="${!empty errorLog}">
                    <td><input type="text" name="login">
                    <font color="red"><b><c:out value="${errorLog}"/></b></font></td>
                </c:when>
                <c:otherwise>
                    <td><input type="text" name="login"></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td>Password: </td>
            <c:choose>
                <c:when test="${!empty errorPass}">
                    <td><input type="password" name="password">
                        <font color="red"><b><c:out value="${errorPass}"/></b></font></td>
                </c:when>
                <c:otherwise>
                    <td><input type="password" name="password"></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td>Full name: </td>
            <c:choose>
                <c:when test="${!empty errorName}">
                    <td><input type="text" name="fullname">
                        <font color="red"><b><c:out value="${errorName}"/></b></font></td>
                </c:when>
                <c:otherwise>
                    <td><input type="text" name="fullname"></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr align="center">
            <td align="center"><input type="submit" value="Register"></td>
        </tr>
    </table>
    </form>
</center>
</body>
</html>
