/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import excepcion.DAOExcepcion;
import java.util.Collection;
import junit.framework.Assert;
import modelo.AlquilerCancha;
import org.junit.Test;

import modelo.Cliente;
import modelo.HorarioCancha;

/**
 *
 * @author Juan
 */
public class AlquilerCanchaTest {

   // @Test
    public void insertarCanchaFulbitoTest() {

        HorarioCancha hc = new HorarioCancha();
        hc.setId(4);  // Crear Tabla 1

        Cliente cliente = new Cliente();
        cliente.setId(2);   // Crear Tabla 1

        AlquilerCancha ac = new AlquilerCancha();
        ac.setHorarioCancha(hc);
        ac.setCliente(cliente);
        ac.setFecha("2012-01-27");
        ac.setHoraInicio("18:00");
        ac.setHoraFin("19:00");

        AlquilerCanchaNegocio can = new AlquilerCanchaNegocio();


        try {
            can.insertar(ac);
        } catch (Exception e) {
            Assert.fail("Falló: " + e.getMessage());
        }

    }

    @Test
    public void testListar() {
        System.out.println("testListar");
        AlquilerCanchaNegocio instance = new AlquilerCanchaNegocio();
        Integer idCliente = null;
        Collection<AlquilerCancha> lista = null;
        try {
            lista = instance.listarHistorico(idCliente);
            if (lista.size() > 0) {
                for (AlquilerCancha alquilercancha : lista) {
                    System.out.println("Cliente :" + alquilercancha.getCliente().getNombre());
                    System.out.println("Fecha :" + alquilercancha.getFecha());
                    System.out.println("Horario Inicio :" + alquilercancha.getHoraInicio());
                    System.out.println("Horario Fin :" + alquilercancha.getHoraFin());
                    System.out.println("Cancha :" + alquilercancha.getHorarioCancha().getCancha().getNombre());
                    System.out.println("");
                }

            } else {
                System.out.println("No se encuentran los datos");
            }
        } catch (DAOExcepcion e) {
            Assert.fail("Falló: " + e.getMessage());
        }

    }
}
