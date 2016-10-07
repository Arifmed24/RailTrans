<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 07.10.2016
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>${title}</title>
  </head>
  <body>
<table border="1">
      <tr>
          <th> Station </th>
          <th> Name </th>
          <th> Change name </th>
      </tr>
      <c:forEach var="station" items="${stations}">
      <tr>
        <td><c:out value="${station.idStation}" /> </td>
        <td><c:out value="${station.stationName}" /> </td>
        <td>
           <form action="/updatestation" method=GET>
                <input type="hidden" name="idStation" value="${station.idStation}">
               <input type="submit" value="update">
           </form>
       </td>
      </tr>
      </c:forEach>
    </table>
   <button>
       <a href="/newstation">Create new station</a>
   </button>
  
  </body>
</html>
