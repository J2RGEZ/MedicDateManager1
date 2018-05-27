<%-- 
    Document   : modifyDate
    Created on : May 27, 2018, 5:36:38 PM
    Author     : forjaser
--%>

<%@page import="java.util.List"%>
<%@page import="Entities.Doctors"%>
<%@page import="Facades.DoctorsFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar</title>
    </head>
    <body>
        <%@include file="Navbar.jspf" %>
        <%  DoctorsFacade ds = InitialContext.doLookup("java:global/MedicDateManager1/MedicDateManager1-ejb/DoctorsFacade!Facades.DoctorsFacade");
            List <Doctors> doctors = ds.findAll();
            int id = Integer.parseInt(request.getParameter("id"));%>
        <form action="FrontServlet" id="modifyDate">
            <input type="hidden" name="command" value="ModifyDateCommand">
            <input type="hidden" name="id" value="<%=id%>">
            Fecha: <input type="date" name="date" value=""><br>
            Doctor: 
                <select name="doctor" form="modifyDate">
                    <%for (Doctors doctor : doctors){%>
                        <option value="<%=doctor.getName()%>"><%=doctor.getName()%></option>
                    <%}%>
                </select><br>
            Nombre: <input type="text" name="user" value=""><br>
            <input type="submit" value="Modificar">
        </form>
    </body>
</html>
