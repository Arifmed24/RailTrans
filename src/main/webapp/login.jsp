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
  <form method="POST" action="/login">
  <table>
  <tr><td>Login:</td><td><input type="text" name="login" /></td></tr>
  <tr><td>Password:</td><td><input type="password" name="password" /></td></tr>
          <tr><td><input type="submit" value="Log in" /></td></tr>
 </tabte>
   </form>
   </center>
   </body>
</html>
