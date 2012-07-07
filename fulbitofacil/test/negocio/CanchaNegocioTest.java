/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import modelo.HorarioCancha;
import java.util.List;
import modelo.Local;
import modelo.Cancha;
import excepcion.DAOExcepcion;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cdiaz
 */
public class CanchaNegocioTest {

    //@Test
    public void testInsertar() {
        System.out.println("testInsertar");
        CanchaNegocio instance = new CanchaNegocio();
        Cancha cancha = new Cancha();
        cancha.setNombre("La canchitaNuevo4");
        cancha.setTarifaDiurna(100.00);
        cancha.setTarifaNocturna(150.00);
        Local local = new Local();
        local.setId(3);
        cancha.setLocal(local);
        List<HorarioCancha> lista = new ArrayList<HorarioCancha>();
        HorarioCancha hc = new HorarioCancha();
        hc.setDia("2012-02-15");
        hc.setHora("19:00");
        lista.add(hc);
        try {
            instance.insertar(cancha, lista);
        } catch (Exception e) {
            fail("Falló: " + e.getMessage());
        }
    }

    //@Test
    public void testInsertar2() {
        System.out.println("testInsertar2-Nombre Repetido");
        CanchaNegocio instance = new CanchaNegocio();
        Cancha cancha = new Cancha();
        cancha.setNombre("La canchita");
        cancha.setTarifaDiurna(100.00);
        cancha.setTarifaNocturna(150.00);
        Local local = new Local();
        local.setId(1);
        cancha.setLocal(local);
        try {
            instance.insertar(cancha, null);
        } catch (Exception e) {
            fail("Falló: " + e.getMessage());
        }
    }

    //@Test
    public void testInsertar3() {
        System.out.println("testInsertar3-Campos Requerido");
        CanchaNegocio instance = new CanchaNegocio();
        Cancha cancha = new Cancha();
        cancha.setTarifaDiurna(100.00);
        cancha.setTarifaNocturna(150.00);
        Local local = new Local();
        local.setId(1);
        cancha.setLocal(local);
        try {
            instance.insertar(cancha, null);
        } catch (Exception e) {
            fail("Falló: " + e.getMessage());
        }
    }
    
    @Test
    public void testListar() {
        System.out.println("testListar");
        CanchaNegocio instance = new CanchaNegocio();
        Integer idCancha = null;
        Integer distrito = null;
        String dia = "2012-02-15";
        String hora = null;
        List<HorarioCancha> lista = null;
        try {
            lista = instance.listar(idCancha, distrito, dia, hora);
            System.out.println("idCancha:" + idCancha);
            System.out.println("distrito:" + distrito);
            System.out.println("dia:" + dia);
            System.out.println("hora:" + hora);
            for (HorarioCancha hc : lista) {
                System.out.println("idHorario=" + hc.getId() + "|dia=" + hc.getDia() + "|hora=" + hc.getHora() + "|cancha=" + hc.getCancha().getNombre() + "|alquilado=" + (hc.isAlquilado() ? "Si" : "No"));
            }
        } catch (Exception e) {
            fail("Falló: " + e.getMessage());
        }
        
    }
}
