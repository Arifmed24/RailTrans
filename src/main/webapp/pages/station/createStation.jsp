<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 07.10.2016
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>${title}</title>
  </head>
  <body>
  <form action="/newstation" method="POST">
    <label>Name of station</label>
     <input type="text" name="name" value="${station.stationName}">
       <br>
       <input type="submit" value="Create">
    </form>
  </body>
</html>
