<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 03/04/2025
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categoria ${categoria.nome}</title>
    <style>
        table, th, td {
            border:1px solid black;
        }
        #menu {
            width: fit-content;
            margin-top:30px;
            display:flex;
            background-color: darkgray;
        }
    </style>
</head>
    <body>
    <%@ include file="header.jsp"%>
    <h1>${categoria.nome}</h1>
    <textarea readonly>${categoria.descrizione}</textarea>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrizione</th>
        </tr>
        <c:forEach items="${prodotti}" var="prodotto">
            <tr>
                <td>${prodotto.id}</td>
                <td>${prodotto.nome}</td>
                <td>${prodotto.descrizione}</td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
