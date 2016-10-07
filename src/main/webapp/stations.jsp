<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 06.10.2016
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Stations</title>
  </head>
  <body>
  <form action="/stations" method="POST">
      Станция: <select name="stationId">
       <c:forEach items="${stations}" var="s">
          <option value="${s.idStation}">${s.stationName}</option>
       </c:forEach>
       </select>
       <br>
       <br>

    Дата:   <input name="date" id="date" type="text" size="9">
      <br>
      <br>
       <input type="submit" value="Выполнить" />
  </form>
  </body>
</html>
