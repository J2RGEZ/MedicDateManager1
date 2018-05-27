<%-- 
    Document   : adminDates
    Created on : May 27, 2018, 11:12:52 AM
    Author     : forjaser
--%>

<%@page import="Facades.DatesFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="Entities.Dates"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Doctors"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Facades.DoctorsFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas</title>
    </head>
    <body>
        <%@include file="Navbar.jspf" %>
        <%  DoctorsFacade ds = InitialContext.doLookup("java:global/MedicDateManager1/MedicDateManager1-ejb/DoctorsFacade!Facades.DoctorsFacade");
            List <Doctors> doctors = ds.findAll();%>
        <h1>Desde este panel puedes ver, crear, actualizar o borrar tus citas</h1>
        <%if (session.getAttribute("citas") == null){%>
            <h3>Parece que aún no tienes citas, ¿quieres crear una?</h3>
            <form action="FrontServlet" id="addDate">
                Nombre: <input type="text" name="user" value=""><br>
                Doctor: 
                <select name="doctor" form="addDate">
                    <%for (Doctors doctor : doctors){%>
                        <option value="<%=doctor.getName()%>"><%=doctor.getName()%></option>
                    <%}%>
                </select><br>
                Date: <input type="date" name="date" value=""><br>
                <input type="hidden" name="command" value="AddDateCommand">
                <input type="submit" value="Añadir cita">
            </form>
        <%}else{
            DatesFacade dt = (DatesFacade) session.getAttribute("citas");
            List<Dates> dates = dt.findAll();%>
            <table align="center">
                <tr>
                    <th>Cita</th>
                    <th>Doctor</th>
                    <th>Paciente</th>
                    <th>Accion1</th>
                    <th>Accion2</th>
                </tr>
            <%for(Dates d : dates){%>
            <tr>
                <td><%=d.getDt()%></td>
                <td><%=d.getDoctor()%></td>
                <td><%=d.getUsername()%></td>
                <td>
                    <form action="modifyDate.jsp">
                        <input type="hidden" name="id" value="<%=d.getId()%>">
                        <input type="submit" value="Modificar">
                    </form>
                </td>
                <td>
                    <form action="FrontServlet">
                        <input type="hidden" name="command" value="DeleteDateCommand">
                        <input type="hidden" name="date" value="<%=d.getDt()%>">
                        <input type="hidden" name="id" value="<%=d.getId()%>">
                        <input type="hidden" name="doctor" value="<%=d.getDoctor()%>">
                        <input type="hidden" name="user" value="<%=d.getUsername()%>">
                        <input type="submit" value="Eliminar">
                    </form>
                </td>   
            </tr>         
        <%}}%>
        </table>
    </body>
</html>
