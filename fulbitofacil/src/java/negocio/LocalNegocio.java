/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.LocalDAO;
import excepcion.DAOExcepcion;
import java.util.List;
import modelo.Local;
import util.StringUtils;

/**
 *
 * @author falfaro
 */
public class LocalNegocio {

    public void insertar(Local vo) throws DAOExcepcion {

        if (StringUtils.isEmpty(vo.getNombre())) {
            throw new DAOExcepcion("Nombre Requerido");
        }
        if (StringUtils.isEmpty(vo.getDireccion())) {
            throw new DAOExcepcion("Dirección Requerido");
        }

        if (StringUtils.isEmpty(vo.getTelefono())) {
            throw new DAOExcepcion("Teléfono Requerido");
        }

        if (vo.getDistritoId() == 0) {
            throw new DAOExcepcion("Distrito Requerido");
        }

        if (vo.getDueño() == null || vo.getDueño().getId() == null) {
            throw new DAOExcepcion("Dueño Requerido");
        }
        LocalDAO localDAO = new LocalDAO();
        Local local = localDAO.obtener(vo.getNombre(), vo.getDueño().getId());
        if (local != null) {
            throw new DAOExcepcion("Este Nombre de Local ya se registró para este Usuario");
        }
        localDAO.insertar(vo);
    }

    public List<Local> listar(Integer idUsuario) throws DAOExcepcion {
        return new LocalDAO().listar(idUsuario);
    }
}