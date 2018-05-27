<%-- 
    Document   : addDoctor
    Created on : May 27, 2018, 6:21:44 PM
    Author     : forjaser
--%>

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
        <%String hospital = request.getParameter("hospital");%>
        <form action="FrontServlet">
            Nombre: <input type="text" name="name" value=""><br>
            Hospital: <input type="text" name="hospital" value="<%=hospital%>" readonly><br>
            Especialidad: <input type="text" name="specialty" value=""><br>
            <input type="hidden" name="command" value="AddDoctorCommand">
            <input type="submit" value="Añadir doctor"><br>
        </form>
    </body>
</html>
