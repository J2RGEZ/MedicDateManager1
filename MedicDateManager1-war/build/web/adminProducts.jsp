<%-- 
    Document   : adminProducts
    Created on : May 27, 2018, 6:47:16 PM
    Author     : forjaser
--%>

<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Products"%>
<%@page import="Facades.ProductsFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <%@include file="Navbar.jspf" %>
        <%
            ProductsFacade products = takeProductsFacadeBean();
            int index = (Integer) request.getAttribute("index");
            List<Products> prod = (List<Products>) request.getAttribute("list");
            int max = products.count();
        %>
            
        
        <table align="center">
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
        <%for (Products product : prod){%>
            <tr>
                <td><%=product.getName() %></td>
                <td><%=product.getPrice() %></td>
            </tr>
        <%}%>
        </table>
        <hr>
        <div style="margin: 0 auto; width: 140px;">
            <a href="/MedicDateManager1-war/FrontServlet?command=ShowProductsCommand&index=<%= minus5(index)%>">Atras | </a>
            <a href="/MedicDateManager1-war/FrontServlet?command=ShowProductsCommand&index=<%= plus5(index, max)%>">Siguiente</a>
        </div>
        
        
    <%!
    public static int minus5(int index) {
        int newIndex = index - 5;
        if (newIndex < 0) {
            return 0;
        }
        return newIndex;
    }

    public static int plus5(int index, int max) {
        int newIndex = index + 5;
        if (newIndex > (max - 5)) {
            return (max - 5);
        }
        return newIndex;

    }
    private ProductsFacade takeProductsFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ProductsFacade) c.lookup("java:global/MedicDateManager1/MedicDateManager1-ejb/ProductsFacade!Facades.ProductsFacade");
            } catch (NamingException ne) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
                throw new RuntimeException(ne);
            }
        }
    %>
        
    </body>
</html>
