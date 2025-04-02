<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 27/03/2025
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostra Clienti</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
    <body>
    <table class="title">
        <tr><th>Clienti Registrati</th></tr>
    </table>
        <h3 style="color: green;">I clienti in verde sono i preferiti</h3>
        <input type="button" onclick="window.location.href='${pageContext.request.contextPath}/'" value="Torna alla home" />
        <ul>
            <c:forEach items="${customers}" var="customer"><%--@elvariable id="color" type="java"--%>
                <c:set var="color" value="${customer.favorite ? 'green' : 'black'}" />
                <li><p style="color: ${color}">${customer.id} ${customer.firstName} ${customer.lastName} ${customer.balance}</p>
                    <form action="UpdateCustomer">
                        <input type="hidden" name="id" value="${customer.id}">
                        <input type="submit" name="button" value="Modifica">
                        <input type="submit" name="button" value="Rimuovi dai preferiti">
                        <input type="submit" name="button" value="Aggiungi ai preferiti">
                    </form>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
