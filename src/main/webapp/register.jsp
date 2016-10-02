<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 02.10.2016
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Registration form</title>
  </head>
  <body>
  <form action="RegisterServlet" method="POST">
  <table>
  <tr>
  <td>login</td>
  <td><input type="text" name="login"/></td>
  </tr>
  <tr>
  <td>password</td>
  <td><input type="text" name="password"/></td>
   </tr>
       <tr>
         <td>fio</td>
         <td><input type="text" name="fio"/></td>
          </tr>
          </table>
  </form>
  </body>
</html>
