<%@ page import="Model.HeaderBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Headers</title>
</head>
<body>
<%
    // 1. Leggi il bean headersBean dalla request
    HeaderBean headersBean = (HeaderBean) request.getAttribute("headers");

    // 2. Ottieni i nomi e i valori dalle due liste
    List<String> headerNames = headersBean.getHeaderNames();
    List<String> headerValues = headersBean.getHeaderValues();

    // 3. Usa un for per stampare le coppie nome valore
    for (int i = 0; i < headerNames.size(); i++) {
%>
<%= headerNames.get(i) %> = <%= headerValues.get(i) %> <br>
<%
    }
%>
<br>
Protocol = <%= request.getProtocol()%>
</body>
</html>
