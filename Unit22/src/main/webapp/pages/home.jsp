<%--
  Created by IntelliJ IDEA.
  User: Kliis
  Date: 28.10.2021
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hello ${sessionScope.user.name}</h1>
<a href="/registration">Registration</a><br>
<a href="/authorization">Authorization</a><br>
<a href="/logout">Logout</a><br>
<a href="/editing">Editing</a><br>
<a href="/delete">Delete</a><br>
</body>
</html>
