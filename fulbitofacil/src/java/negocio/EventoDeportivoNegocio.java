/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.EventoDeportivoDAO;
import excepcion.DAOExcepcion;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EventoDeportivo;

/**
 *
 * @author operador
 */
public class EventoDeportivoNegocio {

    public void insertarEventoDeportivo(String nombre, String premio, int Cantidad, String fecha, int idusuario) throws DAOExcepcion {

        validarnombre(nombre);

        EventoDeportivo modelo = new EventoDeportivo();
        modelo.setNombre(nombre);
        modelo.setPremio(premio);
        modelo.setCantidadEquipos(Cantidad);
        modelo.setFechaInscripcion(fecha);
        modelo.setId(idusuario);

        EventoDeportivoDAO dao = new EventoDeportivoDAO();
        dao.insertarEvento(modelo);
    }

    public void validarnombre(String nombre) throws DAOExcepcion {

        EventoDeportivoDAO modelo = new EventoDeportivoDAO();
        EventoDeportivo obj;

        obj = modelo.obtenerNombre(nombre);
        if (obj != null) {
            throw new DAOExcepcion("Nombre Repetido.");
        }

    }

    public List<EventoDeportivo> listar() throws DAOExcepcion {
        return new EventoDeportivoDAO().listar();
    }
}
