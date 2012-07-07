<%-- 
   Document   : RegistrarCliente
   Created on : 18/02/2012, 03:18:15 AM
   Author     : Francisco
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    ArrayList<String> errores = (ArrayList<String>) request.getAttribute("errores");
%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Fulbito Facil</title>
    <style type="text/css">
        <!--
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            background-color: #F5F7E8;
        }
        -->
    </style>
</head>
<fieldset>   
    <font color="red">
    <table>
        <%
            if (errores != null) {
                for (String s : errores) {
        %>
        <tr>
            <td> <%= s%> </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    </font>

    <form name="RegCliente" action="RegistrarClienteServlet" method="post" onSubmit="return ValidarRegistroCliente()">
        <div id="nav" class="nav"><ul>
                <li>Registro de Clientes</li>
            </ul></div>
        <table border="0">
            <tr><td><font class="labels">Nombre</font></td><td><input type="text" name="nombre" size="40" class="texto"/></td></tr>
            <tr><td><font class="labels">Apellido Paterno</font></td><td><input type="text" name="paterno" size="40" class="texto"/></td></tr>
            <tr><td><font class="labels">Apeliido Materno</font></td><td><input type="text" name="materno" size="40" class="texto"/></td></tr>
            <tr><td><font class="labels">E-mail</font></td><td><input type="text" name="email" size="40" class="texto"/></td></tr>
            <tr><td><font class="labels">Sexo</font></td><td><input type="radio" name="sexo" value="M"/>M<input type="radio" name="sexo" value="F"/>F</td></tr>
            <tr><td><font class="labels">Dni</font></td><td><input type="text" name="dni" size="40" class="texto" maxlength="8"/></td></tr>
            <tr><td><font class="labels">Direccion</font></td><td><input type="text" name="direccion" size="40" class="texto"/></td></tr>
            <tr><td><font class="labels">Distrito</font></td><td><SELECT type="text" name="distrito"/><OPTION VALUE="1">Santiago de Surco</OPTION><OPTION VALUE="2">San Luis</OPTION><OPTION VALUE="3">San Borja</OPTION><OPTION VALUE="3">San Miguel</OPTION></SELECT> </td></tr>
            <tr><td><font class="labels">Fecha Nacimiento</font></td><td><input type="text" name="fnac" size="40" class="texto"/> (yyyy-MM-dd)</td></tr>
            <tr><td><font class="labels">Celular</font></td><td><input type="text" name="celular" size="40" class="texto"/></td></tr>
<!--            <tr><td><font class="labels">Tipo</font></td><td><input type="radio" name="tipo" value="1"/>Dueno<input type="radio" name="tipo" value="2"/>Cliente </td></tr>-->
            <tr><td><font class="labels">Clave</font></td><td><input type="password" name="clave1" value="" size="20" MAXLENGTH="10"/></td></tr>
            <tr><td><font class="labels">Confirmar Clave</font></td><td><input type="password" name="clave2" size="20" MAXLENGTH="10"/></td></tr>     

            <tr><td><button type="reset">
                        <img src="imagenes/delete.gif" alt="" style="height: 17px; "/>Cancelar</button>
                </td><td>
                    <button type="submit">
                        <img src="imagenes/save.png" alt="" style="height: 17px; "/>Registrarme
                    </button>
                </td></tr>
            <tr><td colspan="">${errores}
                </td>
            </tr>
        </table>
    </form>

</fieldset>

