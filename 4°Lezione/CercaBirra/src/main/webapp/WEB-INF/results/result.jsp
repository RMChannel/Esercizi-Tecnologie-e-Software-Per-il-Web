<%@ page import="Model.BeerExpert" %><%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 14/03/2025
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beer advice</title>
    <style>
        body {
            background-color: #fdf5e6;
        }
    </style>
</head>
  <body>
  <h1>Birre consigliate:</h1>
    <%
        BeerExpert beerExpert = (BeerExpert) request.getAttribute("beerExpert");
        for(String advice: beerExpert.getAdivces()) {%>
            <h3>try: <%=advice%> </h3>
        <%}%>
  </body>
</html>
