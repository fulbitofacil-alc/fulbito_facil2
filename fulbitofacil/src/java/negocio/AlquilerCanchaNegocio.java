/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.AlquilerCanchaDAO;
import dao.LocalDAO;
import excepcion.DAOExcepcion;
import excepcion.NegocioExcepcion;
import java.util.Collection;
import java.util.List;
import modelo.AlquilerCancha;
import modelo.Local;
import util.StringUtils;

/**
 *
 * @author Juan y Francisco
 */
public class AlquilerCanchaNegocio {

    public void insertar(AlquilerCancha vo) throws DAOExcepcion, NegocioExcepcion {
        if (vo.getHorarioCancha().getCancha() == null || vo.getHorarioCancha().getCancha().getId() == null) {
            throw new NegocioExcepcion("Cancha Requerido");
        }

        if (StringUtils.isEmpty(vo.getFecha())) {
            throw new NegocioExcepcion("Fecha Requerido");
        }

        if (StringUtils.isEmpty(vo.getHoraFin())) {
            throw new NegocioExcepcion("Hora Fin Requerido");
        }


        if (StringUtils.isEmpty(vo.getHoraInicio())) {
            throw new NegocioExcepcion("Hora Inicio Requerido");
        }

        //if(lista== null || lista.isEmpty()){
        //    throw new NegocioExcepcion("Horario Requerido");
        //}



        AlquilerCanchaDAO alquilerCanchaDAO = new AlquilerCanchaDAO();


        AlquilerCancha cancha = alquilerCanchaDAO.obtener(vo.getHorarioCancha().getId());
        if (cancha != null) {
            throw new DAOExcepcion("Identificador de Cancha ya existe");
        }

        alquilerCanchaDAO.insertar(vo);
    }

    /*
     * public Collection<AlquilerCancha> listarHistorico(Integer idCliente)
     * throws DAOExcepcion {
     *
     * AlquilerCanchaDAO dao = new AlquilerCanchaDAO();
     *
     * Collection<AlquilerCancha> lista = dao.listar(idCliente); return lista; }
     */
    public List<AlquilerCancha> listarHistorico(Integer idUsuario) throws DAOExcepcion {
        AlquilerCanchaDAO dao = new AlquilerCanchaDAO();
        return (List<AlquilerCancha>) dao.listar(idUsuario);
        //return new LocalDAO().listar(idUsuario);
    }
}
