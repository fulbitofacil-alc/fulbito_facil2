/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import excepcion.DAOExcepcion;
import modelo.Dueño;
import modelo.Local;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author falfaro
 */
public class LocalNegocioTest {

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        LocalNegocio instance = new LocalNegocio();
        Local local = new Local();
        local.setNombre("Local Nuevo2");
        local.setDistritoId(1);
        local.setDireccion("Direccion2");
        local.setTelefono("123456");
        Dueño dueño = new Dueño();
        dueño.setId(1);
        local.setDueño(dueño);

        try {
            instance.insertar(local);
        } catch (DAOExcepcion e) {
            fail("Falló: " + e.getMessage());
        }
    }

    //@Test
    public void testInsertar2() {
        System.out.println("Insertar3-Campos Requerido");
        LocalNegocio instance = new LocalNegocio();
        Local local = new Local();
//        local.setNombre("Local Nuevo1");
        local.setDistritoId(1);
        local.setDireccion("Direccion1");
        local.setTelefono("123456");
        Dueño dueño = new Dueño();
        dueño.setId(1);
        local.setDueño(dueño);

        try {
            instance.insertar(local);
        } catch (DAOExcepcion e) {
            fail("Falló: " + e.getMessage());
        }
    }

    //@Test
    public void testInsertar3() {
        System.out.println("Insertar");
        LocalNegocio instance = new LocalNegocio();
        Local local = new Local();
        local.setNombre("Local Nuevo1");
        local.setDistritoId(1);
        local.setDireccion("Direccion1");
        local.setTelefono("123456");
        Dueño dueño = new Dueño();
        dueño.setId(1);
        local.setDueño(dueño);

        try {
            instance.insertar(local);
        } catch (DAOExcepcion e) {
            fail("Falló: " + e.getMessage());
        }
    }
}
