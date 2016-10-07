<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 07.10.2016
  Time: 9:59
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
          <th> Train </th>
          <th> Seats </th>
      </tr>
      <c:forEach var="train" items="${trains}">
      <tr>
        <td><c:out value="${train.idTrain}" /> </td>
        <td><c:out value="${train.seats}" /> </td>
      </tr>
      </c:forEach>
    </table>
   <button>
       <a href="/newtrain">Create new train</a>
   </button>
  </body>
</html>
