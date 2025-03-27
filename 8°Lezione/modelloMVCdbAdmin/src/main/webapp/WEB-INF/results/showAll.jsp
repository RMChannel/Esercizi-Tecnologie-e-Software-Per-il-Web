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
        <ul>
            <c:forEach items="${customers}" var="customer">
                <li>${customer.id} ${customer.firstName} ${customer.lastName} ${customer.balance}
                    <form action="UpdateCustomer">
                        <input type="hidden" name="id" value="${customer.id}">
                        <input type="submit" value="Modifica">
                    </form>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
