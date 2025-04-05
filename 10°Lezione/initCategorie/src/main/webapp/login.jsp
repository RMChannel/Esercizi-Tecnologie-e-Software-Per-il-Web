<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 04/04/2025
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
    <body>
    <h1>Fai il Login</h1>
    <form method="POST" action="login" style="display: inline-grid">
        <label>Username: </label><input type="text" name="username" required><br>
        <label>Password: </label><input type="password" name="password" required><br>
        <input type="submit" value="Login"><br>
    </form>
    <%
        if(request.getAttribute("error")!=null) {
            %>
            <p style="color:red;">Credenziali non valide. Riprova.</p>
            <%
        }
    %>
    </body>
</html>
