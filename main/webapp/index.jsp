
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.servlets.LoginServlet" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    Login: <input type="text" name="login" value=<%= LoginServlet.getLastLogin() %>><br>
    Password: <input type="text" name="password"><br>
    <button type="submit">Login</button>
</form>
</body>
</html>
