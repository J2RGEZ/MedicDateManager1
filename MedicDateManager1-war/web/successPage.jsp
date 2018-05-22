<%-- 
    Document   : success
    Created on : Feb 26, 2018, 9:26:20 AM
    Author     : forjaser
--%>
<%@page import="Stateless.DateContainer"%>
<%@page import="Stateless.Medic"%>
<%@page import="Stateful.User"%>
<%@page import="Stateless.MedicDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cita aceptada</title>
    </head>
        <%@include file="Navbar.jspf" %>
        <h1>Su cita ha sido aceptada por el sistema, muchas gracias por confiar en nosotros</h1>   
</html>
