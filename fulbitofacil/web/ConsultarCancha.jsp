<%-- 
    Document   : ConsultarCancha
    Created on : 15/02/2012, 08:05:22 PM
    Author     : operador
--%>

<%@page import="modelo.AlquilerCancha"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

Collection<AlquilerCancha> lista = (Collection<AlquilerCancha>) request.getAttribute("lista");

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda de Alquiler Cancha</title>
    </head>
    <body>  
    <center>
        </font>
        <p/>
        <form action="ConsultarCanchaServlet" method="post">
            <table border="0">
                <tr>
                    <td>Cliente</td>
                    <td><input type="text" name="cliente" value="" size="20" /></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="text" name="fecha" value="" size="20" /></td>
                </tr>
         
            </table>
            <input type="submit" value="Buscar" name="submit" />
        </form>

        <p>

        <table border="1">
            <thead>
                <tr>
                    <th>Cliente</th>
                    <th>Fecha</th>
                    <th>Hora Inicio</th>
                    <th>Hora Final</th>
                    <th>Cancha</th>
                </tr>
            </thead>
            <tbody>
                 <% if (lista != null) {
                        for (AlquilerCancha ev : lista) {
                %>   
                <tr>
                    <td><%= ev.getCliente() %></td>
                    <td><%= ev.getFecha() %></td>
                    <td><%= ev.getHoraInicio() %></td>
                   <td><%= ev.getHoraFin() %></td>
                   <td><%= ev.getHorarioCancha() %></td>
                </tr>
                <%
                        }
                    }
                %>
                
                
            </tbody>
        </table>
    </center>
</body>
</html>
