<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 17.10.2016
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div>Hello, ${userName}</div>
<form name="form" action="servlet" method="POST">
    <input type="hidden" name="page" value="/main.jsp" />
    <input type="text" placeholder="Name" name="inputName"/>
    <input type="submit" name="showButton" class="input-button" value="Submit" />
</form>
</body>
</html>
