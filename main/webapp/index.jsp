<%@ page import="com.servlets.MyTestServlet" %>
<%@page contentType="text/html; encoding=utf-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Hello App Engine</title>
</head>
<body>
<h1>Type your name and surname</h1>
<table>
    <tr>
        <td colspan="2" style="font-weight: bold;">Available Servlets</td>
    </tr>

    <form action="/forms" method="post">
        First Name: <input type="text" name="firstname" value=<%= MyTestServlet.getName() %>><br>
        Last Name: <input type="text" name="lastname" value=<%= MyTestServlet.getSurname() %>><br>
        <h2>Did you have training today?</h2>
        <input type="radio" name="question" value="yes">Yes<br>
        <input type="radio" name="question" value="no">No<br>
        <button>Send</button>
    </form>
    <tr>
        <td><a href="mytest">MyTest</a></td>
    </tr>
    <tr>
        <td><a href="loginP.jsp">To Login</a></td>
    </tr>
</table>
</body>
</html>
