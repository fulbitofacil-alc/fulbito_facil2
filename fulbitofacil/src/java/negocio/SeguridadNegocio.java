/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.UsuarioDAO;
import excepcion.DAOExcepcion;
import modelo.Usuario;

/**
 *
 * @author cdiaz
 */
public class SeguridadNegocio {

    /*
     * Inicializacion Singleton
     */
    private SeguridadNegocio() {
    }

    private static class LazyHolder {

        public static final SeguridadNegocio INSTANCE = new SeguridadNegocio();
    }

    public static SeguridadNegocio getInstance() {
        return LazyHolder.INSTANCE;
    }

    /*
     * Funciones de negocio
     */
    public Usuario obtener(String correo, String clave) throws DAOExcepcion {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.obtener(correo, clave);
    }
}
