<%-- 
    Document   : adminHospitals
    Created on : May 27, 2018, 5:55:08 PM
    Author     : forjaser
--%>

<%@page import="java.util.List"%>
<%@page import="Entities.Hospitals"%>
<%@page import="Facades.HospitalsFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hospitales</title>
    </head>
    <body>
        <%@include file="Navbar.jspf" %>
        <h1>Si desea añadir un hospital, puede hacerlo desde este formulario</h1>
        <form action="FrontServlet">
            Nombre: <input type="text" name="name" value=""><br>
            Especialidad: <input type="text" name="specialty" value=""><br>
            Localizacion: <input type="text" name="location" value=""><br>
            <input type="hidden" name="command" value="AddHospitalCommand">            
            <input type="submit" value="Añadir hospital">
        </form>
        <hr>    
        <table align="center">
            <tr>
                <th>Nombre</th>
                <th>Especialidad</th>
                <th>Localizacion</th>
                <th>Accion1</th>
            </tr>
        <%
            HospitalsFacade ds = InitialContext.doLookup("java:global/MedicDateManager1/MedicDateManager1-ejb/HospitalsFacade!Facades.HospitalsFacade");
            List<Hospitals> hospitals = ds.sortDates();
        %>
        <%
            for (Hospitals hospital : hospitals){
        %>
                <tr>
                <td><%=hospital.getName()%></td>
                <td><%=hospital.getSpecialty()%></td>
                <td><%=hospital.getLocation() %></td>
                <td>
                    <form action="addDoctor.jsp">
                        <input type="hidden" name="hospital" value="<%= hospital.getName() %>">
                        <input type="submit" value="Añadir Doctor">
                    </form>
                </td>
                </tr>
        <% } %>
        </table>
        <hr>
    </body>
</html>
