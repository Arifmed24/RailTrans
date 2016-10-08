<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 08.10.2016
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Station Timetable</title>
  </head>
  <body>
  <center>
   <h1>Station: ${station} / Date: ${date}</h1>
   <h3>Departure</h3>
   <table border = 1>
          <tr>
             <th> Train </th>
             <th> Route </th>
             <th> To </th>
             <th> Time </th>
         </tr>
<c:forEach var="tableDep" items="${tablesDep}">
      <tr>
        <td align="center"><c:out value="${tableDep.routeId.train.idTrain}"/> </td>
        <td align="center"><c:out value="${tableDep.routeId.routeName}" /></td>
        <td><c:out value="${tableDep.routeId.startStation.stationName}"/> </td>
        <td><c:out value="${tableDep.dateDeparture}"/></td>
      </tr>
      </c:forEach>
    </table>
    <br>
    <br>
     <h3>Arrival</h3>
       <table border = 1>
              <tr>
                 <th> Train </th>
                 <th> Route </th>
                 <th> From </th>
                 <th> Time </th>
             </tr>
    <c:forEach var="tableArr" items="${tablesArr}">
          <tr>
            <td align="center"><c:out value="${tableArr.routeId.train.idTrain}"/></td>
            <td align="center"><c:out value="${tableArr.routeId.routeName}" /></td>
            <td align="center"><c:out value="${tableArr.routeId.finishStation.stationName}"/> </td>
            <td align="center"><c:out value="${tableArr.dateArrival}"/></td>
          </tr>
          </c:forEach>
        </table>
  <center>
  </body>
</html>
