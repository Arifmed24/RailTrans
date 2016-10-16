<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 01.10.2016
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <center>
  Hi, you are on the Login Page
      <form action="/login" method="POST" >
        <table>
            <c:if test="${!empty errorLog || !empty errorPas}">
                <%--<c:if test="${!(empty errorLog)}">--%>
                    <tr><td>Login:</td><td><input type="text" name="login" /></td></tr>
                    <font color="red"><b><c:out value="${errorLog}"/></b></font>
                <%--</c:if>--%>
                <%--<c:if test="${!(empty errorPas)}">--%>
                    <tr><td>Password:</td><td><input type="password" name="password" /></td></tr>
                    <font color="red"><b><c:out value="${errorPas}"/></b></font>
                <%--</c:if>--%>
            </c:if>
              <tr><td><input type="submit" value="Log in" /></td></tr>
       </table>
      </form>
   </center>
   </body>
</html>
