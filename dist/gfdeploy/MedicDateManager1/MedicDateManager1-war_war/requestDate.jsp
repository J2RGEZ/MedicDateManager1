<%-- 
    Document   : comando1
    Created on : Feb 23, 2018, 11:07:58 PM
    Author     : forjaser
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Stateful.MedicProduct"%>
<%@page import="Stateless.Medic"%>
<%@page import="Stateful.User"%>
<%@page import="Stateless.MedicDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@include file="Navbar.jspf" %>
        <%
            MedicProduct product1 = new MedicProduct("Termalgin", 6, "AS corp");
            MedicProduct product2 = new MedicProduct("Propalgina", 15, "AS corp");
            MedicProduct product3 = new MedicProduct("Dalsy", 8, "AS corp");
            MedicProduct product4 = new MedicProduct("Ibuprofeno", 16, "AS corp");
            MedicProduct product5 = new MedicProduct("Codeina", 13, "AS corp");
            ArrayList<MedicProduct> productos = new ArrayList<MedicProduct>();
            productos.add(product1);
            productos.add(product2);
            productos.add(product3);
            productos.add(product4);
            productos.add(product5);
            session.setAttribute("products", productos);
        %>
        <h1>Para pedir una cita, introduzca DNI, nombre y fecha (formato dd/mm/yyyy)</h1>
        <h3>¡Recuerda no dejar campos en blanco!</h3>
        <form action="FrontServlet" id="datePicker">
            Nombre: <input type="text" name="name">
            DNI: <input type="text" name="DNI">
            Doctor:
            <select name="medic" form="datePicker">
                <option value="Ramon">Ramon</option>
                <option value="Juan">Juan</option>
                <option value="Chano">Chano</option>
                <option value="Alicia">Alicia</option>
            </select><br>
            Fecha: <input type="date" name="date"><br>
            <input type="hidden" name="command" value="ProcessDateCommand">
            <input type="submit">
        </form>
    </body>
</html>
