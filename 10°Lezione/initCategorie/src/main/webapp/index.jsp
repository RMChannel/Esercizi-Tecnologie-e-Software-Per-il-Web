<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
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
  <h1>Prodotti</h1>
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
  <form method="GET" action="getCategory">
    <div id="menu">
      <h3>Scegli una categoria: </h3>
      <select name="categoria" id="categoria">
        <c:forEach items="${categorie}" var="categoria">
          <option>${categoria.nome}</option>
        </c:forEach>
      </select>
      <input type="submit" value="Scegli" id="submit">
    </div>
  </form>
  </body>
</html>