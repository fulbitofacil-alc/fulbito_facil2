/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.CanchaDAO;
import excepcion.NegocioExcepcion;
import java.util.List;
import modelo.Cancha;
import modelo.HorarioCancha;
import util.StringUtils;

/**
 *
 * @author Carlos Diaz
 */
public class CanchaNegocio {

    public void insertar(Cancha vo, List<HorarioCancha> lista) throws Exception {
        if (vo.getLocal() == null || vo.getLocal().getId() == null) {
            throw new NegocioExcepcion("Local Requerido");
        }
        if (StringUtils.isEmpty(vo.getNombre())) {
            throw new NegocioExcepcion("Nombre Requerido");
        }
        if (vo.getTarifaDiurna() == 0.0) {
            throw new NegocioExcepcion("Tarifa diruna Requerido");
        }
        if (vo.getTarifaNocturna() == 0.0) {
            throw new NegocioExcepcion("Tarifa diruna Requerido");
        }
        if (lista == null || lista.isEmpty()) {
            throw new NegocioExcepcion("Horario Requerido");
        }

        CanchaDAO canchaDAO = new CanchaDAO();
        Cancha cancha = canchaDAO.obtener(vo.getNombre(), vo.getLocal().getId());
        if (cancha != null) {
            throw new NegocioExcepcion("Identificador de Cancha ya existe");
        }
        canchaDAO.insertar(vo, lista);
    }

    public List<HorarioCancha> listar(Integer idCancha, Integer distrito, String dia, String hora) throws Exception {
        CanchaDAO canchaDAO = new CanchaDAO();
        List<HorarioCancha> lista = canchaDAO.listar(idCancha, distrito, dia, hora);
        return lista;
    }
}
