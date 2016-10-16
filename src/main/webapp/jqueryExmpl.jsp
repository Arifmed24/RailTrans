<%--
  Created by IntelliJ IDEA.
  User: abalaev
  Date: 10.10.2016
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
  <script   src="http://code.jquery.com/jquery-3.1.1.min.js"   integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="   crossorigin="anonymous"></script>
    <title>Title</title>
  </head>
  <body>
   Login <input type="text" id="username"/><br>
   Passowrd <input type="password" id="userSecret"/><br>
    <input type="button" value="Log in" onclick="f();"/>
    <br>
    <span id="textMessg">no message</span>

     <script   src="http://code.jquery.com/jquery-3.1.1.min.js"   integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="   crossorigin="anonymous"></script>


    <script>
    var span;
    var userNameInput;
    var userSecretInput;

    $(function () {
    userNameInput = $("#username");
    userSecretInput = $("#userSecret");
    span = $("#textMessg");
    });

    function f(){

    var username = userNameInput.val();
    var secret = userSecretInput.val();

    $.ajax({
        url: "/jquery",
        type: "POST",
        data : {
            login : username,
            password : secret
        },
        success: function(result) {
            alert(result);
            span.text(result);
        }
    });

    var username = userNameInput.val();
    var secret = userSecretInput.val();
    span.text(username+ " "+ secret);

    }
    </script>
  </body>
</html>
