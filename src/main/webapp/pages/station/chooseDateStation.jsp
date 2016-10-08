<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 08.10.2016
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Choose date and station</title>
  </head>
  <body>
  <form action="/stationtimetable" method="POST">
  Station: <select name="stationId">
         <c:forEach items="${stations}" var="s">
            <option value="${s.idStation}">${s.stationName}</option>
         </c:forEach>
         </select>
         <br>
         <br>
      Date:   <input name="date" id="date" type="text" size="9">
        <br>
        <br>
         <input type="submit" value="Get timetable" />
    </form>
  </body>
</html>
