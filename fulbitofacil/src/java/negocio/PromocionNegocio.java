/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.*;
import excepcion.DAOExcepcion;
import modelo.*;
import util.StringUtils;

/**
 *
 * @author operador
 */
public class PromocionNegocio {

    public void insertar(Promocion vo) throws DAOExcepcion {

        PromocionDAO promocionDAO = new PromocionDAO();

        Promocion promocion = promocionDAO.obtener(vo.getNombre());
        if (promocion != null) {
            throw new DAOExcepcion("La Promocion ya existe");
        }


        promocionDAO.insertar(vo);
    }
}
