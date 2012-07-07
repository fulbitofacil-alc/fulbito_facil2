<%-- 
    Document   : CargarFotos
    Created on : 15/02/2012, 08:48:58 PM
    Author     : operador
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Carga de Fotos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form name="frm" method="post" action="AlbunServlet">
  
    <center> <table border="0">

            <tr>
                <td>
                    <b>Seleccione Evento Deportivo :</b>
                </td>
                <td>
                    <select name="cbo">
                        <option>.:Seleccione:.</option>
                       <c:forEach var="local" items="${listadoEventos}"  >
                        <option VALUE="${EventoDeportivo.idEventoDeportivo}">${EventoDeportivo.nombre}</option>	
                    </c:forEach>
                    </select>
                </td>
                <td rowspan="10"><img src="img/img_Upload.png" width="100" height="100" ></td>
                
            </tr>
                        <tr>
                <td>
                    <b>Nombre de Album :</b>
                </td>
                <td>
                    <input type="text" name="txtnombre"/><input type="submit" value="Grabar" />
                </td>
               
            </tr>
            <tr>
                <td>
                    <b>Comentario :</b>
                </td>
                <td>
                    <input type="text" name="txtcomentario"/>
                </td>
               
            </tr>
            <tr>
                <td>
                    Seleccione Imagen 1 :
                </td>
                <td>
                    <input type="file" name="" value="" />
                </td>
                
            </tr>
             <tr>
                <td>
                    Seleccione Imagen 2 :
                </td>
                <td>
                    <input type="file" name="" value="" />
                </td>
            </tr>
             <tr>
                <td>
                    Seleccione Imagen 3 :
                </td>
                <td>
                    <input type="file" name="" value="" />
                </td>
            </tr>
             <tr>
                <td>
                    Seleccione Imagen 4 :
                </td>
                <td>
                    <input type="file" name="" value="" />
                </td>
            </tr>
             <tr>
                <td>
                    Seleccione Imagen 5 :
                </td>
                <td>
                    <input type="file" name="" value="" />
                </td>
            </tr>
            <tr>
                <td>
                    Seleccione Imagen 6 :
                </td>
                <td>
                    <input type="file" name="" value="" />
                </td>
            </tr>
            <tr>
                <td>
                    Seleccione Imagen 7 :
                </td>
                <td>
                    <input type="file" name="" value="" />
                </td>
            </tr>
            <tr>
                <td>
                    Seleccione Imagen 8 :
                </td>
                <td>
                    <input type="file" name="" value="" />
                </td>
            </tr>
 
        </table></center>
                     </form>
    </body>
</html>