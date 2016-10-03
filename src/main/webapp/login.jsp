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
  TEST
  <form method="POST" action="/login">
          Login:<input type="text" name="login" /><br/>
          Password:<input type="password" name="password" /><br/>
          <input type="submit" value="Log in" />
   </form>
   <div>${info}</div>
  </body>
</html>
