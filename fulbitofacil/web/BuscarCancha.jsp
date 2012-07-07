<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form name="CanchaForm" action="Cancha" method="post">
    <input type="hidden" name="metodo" value="buscar" />
    <table>
        <tr>
            <td><strong><B>BUSCAR CANCHA</B></strong></td>
            <td><br/><br/><br/></td>
        </tr>



        <tr>
            <td>Dia:</td>
            <td><input type="text" name="dia" size="60" maxlength="60" value="${dia}"><br/><br/></td>
        </tr>

        <tr>
            <td>Hora:</td>
            <td><input type="text" name="hora" size="60" maxlength="60" value="${hora}"><br/><br/></td>
        </tr>

        <tr>
            <td>Distrito:</td>
            <td>
                <SELECT name="distrito">
                    <OPTION VALUE="">Seleccione...</OPTION>			
                    <OPTION VALUE="1">Lima</OPTION>		
                    <OPTION VALUE="2">Santiago de Surco</OPTION>		
                    <OPTION VALUE="3">San Borja</OPTION>		
                    <OPTION VALUE="4">La Victoria</OPTION>		
                    <OPTION VALUE="5">San Isidro</OPTION>	
                </SELECT>
                <br/><br/></td>
        </tr>

        <tr>
            <td>Resultados de Busqueda</td>
            <td>
                <table>
                    <tr>
                        <td>Dia</td>
                        <td>Hora</td>
                        <td>Cancha</td>
                        <td>Alquilado</td>

                    </tr>
                    <c:forEach var="hc" items="${listado}"  >
                        <tr>
                            <td>${dia}</td>
                            <td>${hc.hora}</td>
                            <td>${hc.cancha.nombre}</td>
                            <td>${hc.alquilado?"SI":"NO"}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>

        ${mensaje}
        <tr>
            <td><br/><br/><strong><input type="submit" value="Buscar"></strong></td>
            <td><br/><br/><strong><input type="submit" value="Cancelar"></strong></td>
        </tr>
    </table>
</form>