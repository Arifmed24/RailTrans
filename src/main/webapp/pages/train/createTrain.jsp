<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 07.10.2016
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>${title}</title>
  </head>
  <body>
  <form action="/newtrain" method="POST">
  <label>Number of seats in train</label>

    <c:if test="${!(empty error)}">
        <input type="text" name="seats" value="${train.seats}" style="border: 1px solid red">
        <font color="red"><b>Incorrect number of seats!</b></font>
    </c:if>
    <c:if test="${empty error}">
        <input type="text" name="seats" value="${train.seats}">
    </c:if>
     <br>
     <input type="submit" value="Create">
  </form>
  </body>
</html>
