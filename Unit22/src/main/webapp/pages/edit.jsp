<%--
  Created by IntelliJ IDEA.
  User: Kliis
  Date: 28.10.2021
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editing</title>
</head>
<body>
<form action="/editing" method="post">
    <h1>Enter old username and password</h1>
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <h1>Enter a new user and password</h1>
    <input type="text" name="newName" placeholder="new name">
    <input type="password" name="newPassword" placeholder="new password">
    <button>Submit</button>
</form>

</body>
</html>
