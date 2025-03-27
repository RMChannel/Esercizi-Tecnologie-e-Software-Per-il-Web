<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 21/03/2025
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cliente aggunto</title>
</head>
    <body>
    <h2>Il cliente <%=request.getParameter("nome")+" "+request.getParameter("cognome")%> è stato aggiunto alla banca</h2>
    <input type="button" value="Torna indietro" onclick="location.href='../../modelloMVCdb_war_exploded/index.html'"><input type="button" value="Vai alla pagina di visualizzazione" onclick="location.href='../../modelloMVCdb_war_exploded/index2.html'">
    </body>
</html>
