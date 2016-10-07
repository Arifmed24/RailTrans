<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 07.10.2016
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>${title}</title>
  </head>
  <body>
  <form action="/updatestation" method="POST">
      <label>Name of station</label>
       <input type="text" name="idStation" value="${station.stationName}">
         <br>
         <input type="submit" value="Update">
      </form>
  </body>
</html>
