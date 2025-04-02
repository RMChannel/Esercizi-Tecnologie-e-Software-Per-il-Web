<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 27/03/2025
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiorna Cliente</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
    <body>
    <table class="title">
        <tr><th>Aggiorna Cliente</th></tr>
    </table>
        <form action="UpdateCustomer" method="post">
            <fieldset>
                <legend>Form aggiornamento</legend>
                <label>Nome: <input type="text" name="nome" value=${customer.firstName} required></label>
                <label>Cognome: <input type="text" name="cognome" value=${customer.lastName} required></label>
                <label>Bilancio: <input type="number" name="bilancio" value=${customer.balance} step="0.01" required></label>
                <input type="hidden" name="id" value=${customer.id}>
                <input type="submit" value="Salva Modifica">
            </fieldset>
        </form>

    </body>
</html>
