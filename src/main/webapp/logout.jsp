<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 02.10.2016
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Logout page</title>
  </head>
  <body>
<body>
     <%
         session.removeAttribute("login");
         session.removeAttribute("password");
         session.invalidate();
     %>
<center>
     <h1>You have successfully logged out</h1>
     To login again <a href="login.jsp">click here</a>.
</center>
  </body>
</html>
