<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 17.10.2016
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Not Logged in</title>
</head>
<body>
<%--<center>--%>
    <%--<h2>--%>
        <%--Please, log in!--%>
    <%--</h2>--%>
    <%--<a href="/login">Go to log in page</a>--%>
<%--</center>--%>
<c:redirect url="/login"/>
</body>
</html>
