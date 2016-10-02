<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 02.10.2016
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Result page</title>
  </head>
  <body>
  <center>

           <h1>Result Page</h1>
               <b>This is Sample Result Page</b><br/>
               <%=new Date()%></br>
               <%
                   User user = (User) session.getAttribute("user");
               %>
               <b>Welcome <%= user.getFio()%></b>
               <br/>
               <a href="logout.jsp">Logout</a>
           </p>

           <table>
               <thead>
                   <tr>
                       <th>User ID</th>
                       <th>login</th>
                       <th>password</th>
                       <th>fio</th>

                   </tr>
               </thead>
               <tbody>
                   <%
                       LoginService loginService = new LoginService();
                       List<User> list = loginService.getListOfUsers();
                       for (User u : list) {
                   %>
                   <tr>
                       <td><%=u.getIdUser()%></td>
                       <td><%=u.getLogin()%></td>
                       <td><%=u.getPassword()%></td>
                       <td><%=u.getFio()%></td>
                     </tr>
                   <%}%>
               <tbody>
           </table>
           <br/>
      </center>
  </body>
</html>
