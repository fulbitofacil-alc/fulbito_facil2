/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.AlbumDAO;
import modelo.Album;
import excepcion.DAOExcepcion;

/**
 *
 * @author Fernando Llanos
 */
public class AlbumNegocio {

    public void insertarAlbum(int IdEventoDeportivo, String nombre, String comentario, String rutaFotos) throws DAOExcepcion, Exception {

        ValidarDatosDeEntrada(IdEventoDeportivo, nombre, comentario, rutaFotos);
        Album modelo = new Album();
        modelo.setIdEventoDeportivo(IdEventoDeportivo);
        modelo.setNombre(nombre);
        modelo.setComentario(comentario);
        modelo.setRutaFotos(rutaFotos);

        AlbumDAO dao = new AlbumDAO();
        dao.insertarEvento(modelo);
    }

    public void ValidarDatosDeEntrada(int IdEventoDeportivo, String nombre, String comentario, String rutaFotos) throws Exception {
        String msg = "";
        if (IdEventoDeportivo < 0) {
            msg += "\n Debe Ingresar El Evento Deportivo";
        }
        if (nombre.equals("")) {
            msg += "\n Debe Ingresar un Nombre de Evento";
        }
        if (comentario.equals("")) {
            msg += "\n Debe ingresar un comentario";
        }
        if (rutaFotos.equals("")) {
            msg += "\n Debe ingresar la ruta del Album";
        }
        if (!msg.equals("")) {
            throw new Exception(msg);
        }
    }
}
