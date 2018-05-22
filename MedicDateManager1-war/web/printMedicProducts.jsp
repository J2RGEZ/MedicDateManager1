<%-- 
    Document   : printMedicProducts
    Created on : May 22, 2018, 3:40:38 PM
    Author     : forjaser
--%>

<%@page import="Stateful.MedicProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <%@include file="Navbar.jspf" %>
        <table align="center">
            <tr>
                <th>Nombre</th>
                <th>Precio (eur)</th>
                <th>Fabricante</th>
                <th>Checkout</th>
            </tr>
        <%
            int id = 0;
            ArrayList<MedicProduct> productos = (ArrayList<MedicProduct>) session.getAttribute("products");
            for(MedicProduct product : productos){
                String name = product.getName();
                int price = product.getPrice();
                String manufacturer = product.getManufacturer();
        %>    
                <tr>
                    <td><%= name %></td>
                    <td><%= price %></td>
                    <td><%= manufacturer %></td>
                    <td>
                        <form action="FrontServlet">
                            <input name="id" value=<%=id%>>
                            <input type="hidden" name="command" value="CartCommand">
                            <input type="submit" value="Añadir al carrito">
                        </form>
                    </td>
                </tr>
                
            <%id++;}%>
        </table>
    </body>
</html>
