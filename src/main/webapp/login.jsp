<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 01.10.2016
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <center>
  Hi, you are on the Login Page
      <form action="/login" method="POST" >
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
                    <c:when test="${!empty errorPas}">
                        <td><input type="password" name="password">
                            <font color="red"><b><c:out value="${errorPas}"/></b></font></td>
                    </c:when>
                    <c:otherwise>
                        <td><input type="password" name="password"></td>
                    </c:otherwise>
                </c:choose>
            </tr>
              <tr>
                  <td><input type="submit" value="Log in" /></td>
              </tr>
              <tr>
                  <td>
                     <a href="/registration">
                          <input type="button" value="Register">
                     </a>
                  </td>
              </tr>
       </table>
      </form>
   </center>
   </body>
</html>
