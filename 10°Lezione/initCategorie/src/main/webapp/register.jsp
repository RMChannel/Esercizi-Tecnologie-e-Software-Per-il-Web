<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 04/04/2025
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registrazione</title>
    <style>
        p {
            color: red;
        }
    </style>
</head>
<body>
<h1>Registrati al sito</h1>
<form method="POST" action="register" style="display: inline-grid">
    <label>Username: </label><input type="text" name="username" required><br>
    <label>Email: </label><input type="email" name="email" required><br>
    <label>Password: </label><input type="password" name="password" required><br>
    <label>Conferma Password: </label><input type="password" name="confirm_password" required><br>
    <input type="submit" value="Registrati"><br>
</form>
<%
    if(request.getAttribute("error")==null);
    else if(request.getAttribute("error")=="1") {
%>
<p>Username già esistente, riprova con un altro</p>
<%
    }
    else if(request.getAttribute("error")=="2") {
%>
<p>Email già registrata, registrati con un'altra mail e riprova</p>
<%
    }
%>
</body>
</html>