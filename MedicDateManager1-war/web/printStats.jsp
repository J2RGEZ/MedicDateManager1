<%-- 
    Document   : printStats
    Created on : May 23, 2018, 5:01:47 PM
    Author     : forjaser
--%>

<%@page import="Singleton.Stadistics"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estadisticas</title>
    </head>
    <body>
        <%@include file="Navbar.jspf" %>
        <h1>Citas realizadas: <%= Stadistics.getDate()%></h1>
        
        <h1>Número de productos: <%= Stadistics.getCarti() %></h1>
        <% for (Map.Entry<String, Integer> entry : Stadistics.getCart().entrySet()) {%>
        <h3><%= entry.getKey()%> - <%= entry.getValue()%></h3> 
        <% }%>

    </body>
</html>
