/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.UsuarioDAO;
import excepcion.DAOExcepcion;
import modelo.Usuario;
import util.StringUtils;

/**
 *
 * @author Francisco
 */
public class UsuarioNegocio {

    public void insertar(Usuario vo) throws DAOExcepcion {

        if (StringUtils.isEmpty(vo.getCorreo())) {
            throw new DAOExcepcion("Correo Requerido");
        }
        if (StringUtils.isEmpty(vo.getDni())) {
            throw new DAOExcepcion("Dni Requerido");
        }

        if (StringUtils.isEmpty(vo.getClave())) {
            throw new DAOExcepcion("Clave Requerida");
        }

        if (StringUtils.isEmpty(vo.getNombre())) {
            throw new DAOExcepcion("Nombres Requeridos");
        }
        if (StringUtils.isEmpty(vo.getApellidoPaterno())) {
            throw new DAOExcepcion("Apellido Paterno Requerido");
        }
        if (StringUtils.isEmpty(vo.getApellidoMaterno())) {
            throw new DAOExcepcion("Apellido Materno Requerido");
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.obtenerCorreo(vo.getCorreo());
        if (usuario != null) {
            throw new DAOExcepcion("El correo ya existe");
        }
        if (usuarioDAO.obtenerdni(vo.getDni()) != null) {
            throw new DAOExcepcion("El DNI ya existe");
        }

        usuarioDAO.insertar(vo);
    }
}
