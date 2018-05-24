<%-- 
    Document   : printDates
    Created on : May 22, 2018, 11:26:27 AM
    Author     : forjaser
--%>

<%@page import="Singleton.Log"%>
<%@page import="Stateless.Medic"%>
<%@page import="Stateful.User"%>
<%@page import="Stateless.MedicDate"%>
<%@page import="Stateless.DateContainer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis citas</title>
    </head>
    <body>
        <% Log.saveJSP("Pidiendo fecha");%>
        <%@include file="Navbar.jspf" %>
        <% if (session.getAttribute("medicDate") == null){ %>
        <h1>Parece que no has pedido ninguna cita</h1>
        <%}else{%>
            <%
            DateContainer container = (DateContainer) session.getAttribute("medicDate");
            for (int i = 0; i < container.getContainer().size(); i++){
                MedicDate date = container.getContainer().get(i);
                String medDate = date.getMedicDate();
                User user = date.getUser();
                Medic medic = date.getMedic();
            %>
                <p>Su fecha es: <%= medDate %></p>
                <p>Su nombre es: <%= user.getName() %></p>
                <p>Su dni es: <%= user.getPass() %></p>
                <p>Su doctor es: <%= medic.getName() %></p>
                <p>///////////////////////////<p>
            <%}%>
        <%}%>
    </body>
</html>
