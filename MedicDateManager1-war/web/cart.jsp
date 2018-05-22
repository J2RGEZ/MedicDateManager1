<%-- 
    Document   : cart
    Created on : May 22, 2018, 5:01:11 PM
    Author     : forjaser
--%>

<%@page import="java.util.HashMap"%>
<%@page import="Stateful.MedicProduct"%>
<%@page import="Stateful.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Navbar.jspf" %>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null){
        %>
                <h1>Parece que aun no se ha añadido ningún producto</h1>
            <%}else{
                for (HashMap.Entry<MedicProduct, Integer> entry : cart.getCart().entrySet()) {
                    
                }
              }%>
    </body>
</html>
