/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import excepcion.DAOExcepcion;
import modelo.Cliente;

/**
 *
 * @author francisco
 */
public class ClienteNegocio extends UsuarioNegocio {

    public void insertar(Cliente vo) throws DAOExcepcion {
        super.insertar(vo);
    }
}
