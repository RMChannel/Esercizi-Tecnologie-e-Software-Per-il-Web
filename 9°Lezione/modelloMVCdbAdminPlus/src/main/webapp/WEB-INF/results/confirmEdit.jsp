<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 27/03/2025
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css"/>
<html>
<head>
    <title>Update effettuato con successo</title>
</head>
  <body>
    <table class="title">
      <tr><th>Update Effettuato</th></tr>
    </table>
    <h1>Il tuo update è stato effettuato correttamente</h1>
    <h3>I dati aggiornati sono:</h3>
      ID: ${customer.id}<br>
      Nome: ${customer.firstName}<br>
      Cognome: ${customer.lastName}<br>
      Bilancio: ${customer.balance}<br>
  <input type="button" value="Torna indietro" onclick="location.href='${pageContext.request.contextPath}/index.html'">
  </body>
</html>
